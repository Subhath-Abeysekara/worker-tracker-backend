package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface adminRepository extends JpaRepository<admin, Integer> {
    admin findByUsername(String username);
    @Transactional
    @Modifying
    @Query("update admin A set A.username=:username where A.username=:oldUsername")
    void setUsername(String oldUsername, String username);
    @Transactional
    @Modifying
    @Query("update admin A set A.password=:password where A.password=:oldPassword")
    void setPassword(String oldPassword, String password);
}
