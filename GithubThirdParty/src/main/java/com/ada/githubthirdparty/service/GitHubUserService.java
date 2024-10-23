package com.ada.githubthirdparty.service;

import com.ada.githubthirdparty.feign.GitHubClient;
import com.ada.githubthirdparty.model.User;
import com.ada.githubthirdparty.repository.UserRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Optional;

@Service
public class GitHubUserService {


    private final GitHubClient githubClient;
    private final UserRepository userRepository;

    public GitHubUserService(GitHubClient githubClient , UserRepository userRepository){
        this.githubClient = githubClient;
        this.userRepository = userRepository;
    }

    public User save(String username){

        Optional<User> existingUser = userRepository.findUserByUsername(username);

        if (existingUser.isPresent()){
            System.out.println("User Already Exist");
          return existingUser.get();
        }

        Map<String ,Object > userInfo = githubClient.getUserInfo(username);
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode userNode = objectMapper.convertValue(userInfo , JsonNode.class);

        User user = new User();


        if (userNode.has("login")){
            user.setUsername(userNode.get("login").asText());
        }

        if(userNode.has("name")){
            String fullName = userNode.get("name").asText();
            String[] nameParts = fullName.split(" " , 2);


            user.setName(nameParts[0]);
            if (nameParts.length >1){
                user.setFamily(nameParts[1]);
            }else user.setFamily("");

        }

        if(userNode.has("company")){
            user.setCompany(userNode.get("company").asText());
        }

        if(userNode.has("location")){
            user.setLocation(userNode.get("location").asText());
        }
        if (userNode.has("email")){
            user.setEmail(userNode.get("email").asText());
        }
        if (userNode.has("twitter_username")){
            user.setTwitter(userNode.get("twitter_username").asText());
        }

        user.setDeleted(false);
        return userRepository.saveAndFlush(user);





    }
}
