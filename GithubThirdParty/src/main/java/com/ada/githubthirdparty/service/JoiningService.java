package com.ada.githubthirdparty.service;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.repository.RepoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class JoiningService {

    private final GitHubClient gitHubClient;
    private final RepoRepository repoRepository;

    private final GitHubUserService gitHubUserService;

    public JoiningService(GitHubClient gitHubClient,RepoRepository repoRepository  , GitHubUserService gitHubUserService){
        this.gitHubClient = gitHubClient;
        this.repoRepository =  repoRepository;

        this.gitHubUserService = gitHubUserService;
    }

    public List<GitRepository> save(String username){


        List<Map<String, Object>> repos = gitHubClient.getUserRepos(username);

        ObjectMapper objectMapper = new ObjectMapper();

        List<GitRepository> repoList = repos.stream().map(repo -> {
            JsonNode repoNode = objectMapper.convertValue(repo, JsonNode.class);

            GitRepository gitRepository = new GitRepository();

            if (repoNode.has("name")) {
                gitRepository.setName(repoNode.get("name").asText());
            }
            if (repoNode.has("description")) {
                gitRepository.setAbout(repoNode.get("description").asText());
            }

            if (repoNode.has("owner") && repoNode.get("owner").has("login")) {
                String ownerUsername = repoNode.get("owner").get("login").asText();
                gitRepository.setOwner(gitHubUserService.save(ownerUsername));
            }

            if (repoNode.has("watchers_count")) {
                gitRepository.setWatchingNo(repoNode.get("watchers_count").asInt());
            }
            if (repoNode.has("stargazers_count")) {
                gitRepository.setStarsNo(repoNode.get("stargazers_count").asInt());
            }
            if (repoNode.has("forks_count")) {
                gitRepository.setForkNo(repoNode.get("forks_count").asInt());
            }


            if (repoNode.has("created_at")) {
                gitRepository.setPublishYear(LocalDate.parse(repoNode.get("created_at").asText().substring(0, 10)));
            }

            gitRepository.setDeleted(false);

            return gitRepository;
        }).toList();

        return repoRepository.saveAll(repoList);
    }

    public List<GitRepository> findAll(){
        return repoRepository.findAll();
    }
}
