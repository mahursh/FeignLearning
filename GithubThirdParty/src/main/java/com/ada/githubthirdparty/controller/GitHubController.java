package com.ada.githubthirdparty.controller;

import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.model.User;
import com.ada.githubthirdparty.service.GitHubRepoService;
import com.ada.githubthirdparty.service.GitHubUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {

    private final GitHubRepoService repoService;
    private final GitHubUserService userService;


    public GitHubController(GitHubRepoService repoService , GitHubUserService userService){
        this.repoService = repoService;
        this.userService = userService;
    }

    @GetMapping("/repos/{username}")
    public ResponseEntity<List<GitRepository>> getRepos(@PathVariable String username) {
        List<GitRepository> repos = repoService.save(username);
        return ResponseEntity.ok(repos);


    }

    @GetMapping("/userInfo/{username}")
    public ResponseEntity<User> getUserInfo(@PathVariable String username){
        User user = userService.save(username);
        return ResponseEntity.ok(user);
    }
}
