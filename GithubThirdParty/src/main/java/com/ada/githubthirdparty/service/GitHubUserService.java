package com.ada.githubthirdparty.service;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.User;
import com.ada.githubthirdparty.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GitHubUserService {


    private final GitHubClient githubClient;
    private final UserRepository userRepository;

    public GitHubUserService(GitHubClient githubClient , UserRepository userRepository){
        this.githubClient = githubClient;
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
