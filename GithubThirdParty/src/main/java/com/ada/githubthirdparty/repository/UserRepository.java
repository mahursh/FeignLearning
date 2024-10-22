package com.ada.githubthirdparty.repository;

import com.ada.githubthirdparty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{
}
