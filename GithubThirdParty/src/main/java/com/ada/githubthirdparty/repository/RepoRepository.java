package com.ada.githubthirdparty.repository;

import com.ada.githubthirdparty.model.GitRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRepository extends JpaRepository< GitRepository ,Long > {


    @Modifying
    @Query("update repoEntity  oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(Long id);
}
