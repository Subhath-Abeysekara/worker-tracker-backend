package com.workTraker.backend.Service;


import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.workTraker.backend.Entity.*;

import java.util.List;
import java.util.Optional;

public interface commonMethodService {

    String addEmployee(employee employee);
    List<employee> getEmployees(Long id);

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

    String addMassage(massages massage);

    List<msgResBody> getRMassages(Long mid , Long rid);

    List<msgResBody> getSMassages(Long mid , Long sid);

    employee getEmployee(Long id);

}
