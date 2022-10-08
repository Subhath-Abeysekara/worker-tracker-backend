package com.workTraker.backend.Repository.exception;

import com.workTraker.backend.Entity.employee;
import com.workTraker.backend.Entity.project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface projectRepo extends JpaRepository<project, Long> {
    Optional<project> findByProjectCode(String code);
}
