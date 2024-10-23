package com.ada.githubthirdparty.repository;

import com.ada.githubthirdparty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

    @Modifying
    @Query("update userEntity  oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(Long id);
}
