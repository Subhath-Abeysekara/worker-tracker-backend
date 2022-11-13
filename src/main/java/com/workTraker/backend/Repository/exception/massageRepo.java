package com.workTraker.backend.Repository.exception;

import com.workTraker.backend.Entity.employee;
import com.workTraker.backend.Entity.massages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface massageRepo extends JpaRepository<massages, Long> {
    List<massages> findByMeetingIdAndReceiverId(Long meetingId , Long rId);
    List<massages> findByMeetingIdAndSenderId(Long meetingId , Long sId);
}
