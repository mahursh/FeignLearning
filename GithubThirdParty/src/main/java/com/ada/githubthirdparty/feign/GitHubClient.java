package com.ada.githubthirdparty.feign;


import com.ada.githubthirdparty.model.GitRepository;
import com.ada.githubthirdparty.model.User;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "githubClient", url = "https://api.github.com" /*, configuration = FeignConfig.class */)
public interface GitHubClient {

    @GetMapping(value = "/users/{username}/repos")
    List<GitRepository> getUserRepos(@PathVariable("username") String username);

    @GetMapping(value = "/users/{username}")
    User getUserInfo(@PathVariable("username") String username);
}
