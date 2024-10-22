package com.ada.githubthirdparty.service;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.repository.RepoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubRepoService {

    private final GitHubClient gitHubClient;
    private final RepoRepository repoRepository;

    public GitHubRepoService(GitHubClient gitHubClient,RepoRepository repoRepository){
        this.gitHubClient = gitHubClient;
        this.repoRepository =  repoRepository;
    }

    public void save(GitRepository repo){
        repoRepository.save(repo);
    }

    public List<GitRepository> findAll(){
        return repoRepository.findAll();
    }
}
