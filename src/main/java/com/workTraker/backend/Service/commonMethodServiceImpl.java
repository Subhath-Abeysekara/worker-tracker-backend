package com.workTraker.backend.Service;




import com.workTraker.backend.Entity.*;
import com.workTraker.backend.Repository.exception.*;
import com.workTraker.backend.Service.commonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService {

    @Autowired
    private employeeRepo employeeRepo;

    @Autowired
    private meetingRepo meetingRepo;

    @Autowired
    private empMeetRepo empMeetRepo;

    @Autowired
    private requestRepo requestRepo;

    @Autowired
    private projectRepo projectRepo;
    @Override
    public String addEmployee(employee employee) {
        employeeRepo.save(employee);
        return "added";
    }

    @Override
    public List<employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public String addMeeting(meetingAddBody meetingAddBody) {
        List<meeting> meetings = meetingRepo.findAll();
        Long orgEmp = meetingAddBody.getMeeting().getOrg_emp_id();
        for(meeting meeting : meetings)
        {
            if(meeting.getOrg_emp_id().equals(orgEmp)&&meeting.getStatus().equals("pending")){
                return "cant add new one you have already shedueled a meeting";
            }
        }
        Long meetingId = meetingRepo.save(meetingAddBody.getMeeting()).getMeetingId();

        for(Long id : meetingAddBody.getEmployees()){
            employeesOfMeeting employeesOfMeeting = new employeesOfMeeting();
            employeesOfMeeting.setMeetingId(meetingId);
            employeesOfMeeting.setEmpId(id);
            empMeetRepo.save(employeesOfMeeting);
        }
        return "added";
    }

    @Override
    public meeting getMeetByEmp(Long empId) {
        List<meeting> meetings = meetingRepo.findAll();
        for(meeting meeting : meetings)
        {
            if(meeting.getOrg_emp_id().equals(empId)&&meeting.getStatus().equals("pending")){
                return meeting;
            }
        }
        return null;
    }

    @Override
    public String startMeeting(Long empId) {

        List<meeting> meetings = meetingRepo.findAll();
        for(meeting meeting : meetings)
        {
            if(meeting.getOrg_emp_id().equals(empId)&&meeting.getStatus().equals("pending")){
                meeting.setStatus("start");
                meetingRepo.save(meeting);
                return "started";
            }
        }
        return "Time has expired or already started";
    }

    @Override
    public Long addRequest(request request) {
        return requestRepo.save(request).getReqId();

    }

    @Override
    public String acceptRequest(Long id) {
        List<request> requests = requestRepo.findAll();
        for(request request : requests){
            if(request.getReceiver_id()!=null){
                if(request.getAcceptStatus().equals("pending")&&request.getReceiver_id().equals(id)){
                    request.setAcceptStatus("accept");
                    requestRepo.save(request);
                    return "accepted";
                }
            }

        }
        return "error Id";
    }

    @Override
    public String cancelRequest(Long id) {
        List<request> requests = requestRepo.findAll();
        for(request request : requests){
            if(request.getReceiver_id()!=null){
                if(request.getAcceptStatus().equals("pending")&&request.getReceiver_id().equals(id)){
                    request.setAcceptStatus("cancel");
                    requestRepo.save(request);
                    return "canceled";
                }
            }

        }
        return "error Id";
    }

    @Override
    public request showRequest(Long id) {
        List<request> requests = requestRepo.findAll();
        for(request request : requests){
            if(request.getReceiver_id()!=null){
                if(request.getAcceptStatus().equals("pending")&&request.getReceiver_id().equals(id)){
                    return request;
                }
            }
        }
        return null;
    }

    @Override
    public String showResponse(Long id) {
        Optional<request> request = requestRepo.findById(id);
        if (request.isPresent()){
            return request.get().getAcceptStatus();
        }
        return "error Id";
    }

    @Override
    public String addProject(project project) {
        projectRepo.save(project);
        return "added";
    }

    @Override
    public String addEmployeeToProject(Long empId, Long pID) {
        Optional<employee> employee = employeeRepo.findById(empId);
        if (employee.isPresent()){
            employee.get().setProjectId(pID);
            return "added";
        }
        return "error id";
    }

    @Override
    public int getEmpRate(Long id) {
        Optional<employee> employee = employeeRepo.findById(id);
        return employee.map(com.workTraker.backend.Entity.employee::getRate).orElse(0);
    }

    @Override
    public List<project> getProjectsByIds(List<String> codes) {
        List<project> projects = new ArrayList<>();
        for (String code : codes){
            Optional<project> project = projectRepo.findByProjectCode(code);
            project.ifPresent(projects::add);
        }
        return projects;
    }

    @Override
    public List<project> getAllProjects() {
        return projectRepo.findAll();
    }
}
