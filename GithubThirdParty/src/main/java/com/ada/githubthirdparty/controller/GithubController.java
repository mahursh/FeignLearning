package com.ada.githubthirdparty.controller;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GithubController implements GitHubClient {


    @Override
    public List<GitRepository> getUserRepos(String username) {
        return List.of();
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }
}
