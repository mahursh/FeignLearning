package com.ada.githubthirdparty.service;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.model.enums.Languages;
import com.ada.githubthirdparty.repository.RepoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;


@Service
public class GitHubRepoService {

    private final GitHubClient gitHubClient;
    private final RepoRepository repoRepository;

    public GitHubRepoService(GitHubClient gitHubClient,RepoRepository repoRepository){
        this.gitHubClient = gitHubClient;
        this.repoRepository =  repoRepository;
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
                gitRepository.setOwner(repoNode.get("owner").get("login").asText());
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

//            if (repoNode.has("languages")) {
//                Set<Languages> languages = new HashSet<>();
//                JsonNode languagesNode = repoNode.get("languages");
//                if (languagesNode != null) {
//                    languagesNode.fieldNames().forEachRemaining(lang -> {
//                        languages.add(Languages.valueOf(lang.toUpperCase()));
//                    });
//                }
//                 gitRepository.setLanguages(languages);
//            }

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
