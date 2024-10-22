package com.ada.githubthirdparty.controller;

import com.ada.githubthirdparty.service.GitHubRepoService;
import com.ada.githubthirdparty.service.GitHubUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubController {

    private final GitHubRepoService repoService;
    private final GitHubUserService userService;


    public GitHubController(GitHubRepoService repoService , GitHubUserService userService){
        this.repoService = repoService;
        this.userService = userService;
    }

    @GetMapping("/repos/{username}")
    public String saveRepos(@PathVariable("username") String username){
        repoService.save(username);
        return "saved ";
    }


}
