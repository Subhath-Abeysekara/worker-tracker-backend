package com.workTraker.backend.Service;


import com.workTraker.backend.Entity.*;

import java.util.List;

public interface commonMethodService {

    String addEmployee(employee employee);
    List<employee> getEmployees();

    String addMeeting(meetingAddBody meetingAddBody);

    meeting getMeetByEmp(Long empId);

    String startMeeting(Long empId);

    Long addRequest(request request);

    String acceptRequest(Long id , Long id2);

    String cancelRequest(Long id , Long id2);

    request showRequest(Long id);

    String showResponse(Long id);

    String addProject(project project);

    String addEmployeeToProject(Long empId , Long pID);

    int getEmpRate(Long id);

    List<project> getProjectsByIds(List<String> codes);

    List<project> getAllProjects();

}
