package com.workTraker.backend.Service;




import com.workTraker.backend.Entity.*;
import com.workTraker.backend.Repository.exception.empMeetRepo;
import com.workTraker.backend.Repository.exception.employeeRepo;
import com.workTraker.backend.Repository.exception.meetingRepo;
import com.workTraker.backend.Repository.exception.requestRepo;
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
                return "started";
            }
        }
        return "Time has expended";
    }

    @Override
    public String addRequest(request request) {
        requestRepo.save(request);
        return "added";
    }

    @Override
    public String acceptRequest(Long id) {
        Optional<request> request = requestRepo.findById(id);
        if (request.isPresent()){
            request.get().setAcceptStatus("accept");
            requestRepo.save(request.get());
        }
        return "error Id";
    }

    @Override
    public String cancelRequest(Long id) {
        Optional<request> request = requestRepo.findById(id);
        if (request.isPresent()){
            request.get().setAcceptStatus("cancel");
            requestRepo.save(request.get());
        }
        return "error Id";
    }

    @Override
    public request showRequest(Long id) {
        Optional<request> request = requestRepo.findById(id);
        return request.orElse(null);
    }

    @Override
    public String showResponse(Long id) {
        Optional<request> request = requestRepo.findById(id);
        if (request.isPresent()){
            return request.get().getAcceptStatus();
        }
        return "error Id";
    }
}
