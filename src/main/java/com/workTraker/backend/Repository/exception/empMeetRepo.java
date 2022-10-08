package com.workTraker.backend.Repository.exception;

import com.workTraker.backend.Entity.employeesOfMeeting;
import com.workTraker.backend.Entity.meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empMeetRepo extends JpaRepository<employeesOfMeeting, Long> {
}
