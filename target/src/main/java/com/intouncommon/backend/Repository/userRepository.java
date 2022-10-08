package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<users, Long> {
    @Query("select U.contact from users U where U.userId=:id")
    String getContact(Long id);
}
