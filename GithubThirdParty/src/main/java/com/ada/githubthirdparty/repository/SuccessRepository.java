package com.ada.githubthirdparty.repository;

import com.ada.githubthirdparty.model.SuccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessRepository extends JpaRepository<SuccessEntity , Long> {
}
