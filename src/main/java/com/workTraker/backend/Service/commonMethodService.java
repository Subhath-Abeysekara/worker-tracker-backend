package com.workTraker.backend.Service;


import com.workTraker.backend.Entity.employee;
import com.workTraker.backend.Entity.meeting;
import com.workTraker.backend.Entity.meetingAddBody;
import com.workTraker.backend.Entity.request;

import java.util.List;

public interface commonMethodService {

    String addEmployee(employee employee);
    List<employee> getEmployees();

    String addMeeting(meetingAddBody meetingAddBody);

    meeting getMeetByEmp(Long empId);

    String startMeeting(Long empId);

    String addRequest(request request);

    String acceptRequest(Long id);

    String cancelRequest(Long id);

    request showRequest(Long id);

    String showResponse(Long id);

}
