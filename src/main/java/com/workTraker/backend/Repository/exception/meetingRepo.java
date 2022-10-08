package com.workTraker.backend.Repository.exception;

import com.workTraker.backend.Entity.employee;
import com.workTraker.backend.Entity.meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface meetingRepo extends JpaRepository<meeting, Long> {
}
