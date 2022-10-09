package com.workTraker.backend.Controller;

import com.workTraker.backend.Entity.*;
import com.workTraker.backend.Service.commonMethodService;
import com.workTraker.backend.Service.commonMethodService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workTraker")
public class commonController {

    @Autowired
    private commonMethodService commonMethodService;

    @PostMapping("/addEmployee")
    private String send(@RequestBody employee employee){
        return commonMethodService.addEmployee(employee);
    }

    @GetMapping("/getEmployees")
    private List<employee> getAll(){
        return commonMethodService.getEmployees();
    }

    @PostMapping("addMeeting")
    private String addMeet(@RequestBody meetingAddBody meetingAddBody){
        return commonMethodService.addMeeting(meetingAddBody);
    }

    @GetMapping("/getMeeting/{id}")
    private meeting getMeet(@PathVariable Long id){
        return commonMethodService.getMeetByEmp(id);
    }

    @PutMapping("/startMeeting/{id}")
    private String startMeet(@PathVariable Long id){
        return commonMethodService.startMeeting(id);
    }

    @PostMapping("addRequest")
    private String addRequest(@RequestBody request request){
        return commonMethodService.addRequest(request);
    }

    @GetMapping("/getRequest/{id}")
    private request getRequest(@PathVariable Long id){
        return commonMethodService.showRequest(id);
    }

    @GetMapping("/getResponse/{id}")
    private String getResponse(@PathVariable Long id){
        return commonMethodService.showResponse(id);
    }

    @PutMapping("/cancelRequest/{id}")
    private String cancelRequest(@PathVariable Long id){
        return commonMethodService.cancelRequest(id);
    }

    @PutMapping("/acceptRequest/{id}")
    private String startRequest(@PathVariable Long id){
        return commonMethodService.acceptRequest(id);
    }

    @PostMapping("addProject")
    private String addProject(@RequestBody project project){
        return commonMethodService.addProject(project);
    }

    @PutMapping("/addEmpProject/{pid}/{eid}")
    private String addempProject(@PathVariable Long pid , @PathVariable Long eid){
        return commonMethodService.addEmployeeToProject(eid,pid);
    }

    @GetMapping("/getRate/{id}")
    private int getEmpRate(@PathVariable Long id){
        return commonMethodService.getEmpRate(id);
    }

    @PostMapping("/getProjectsEmp")
    private List<project> getResponse(@RequestBody bodyList bodyList){
        return commonMethodService.getProjectsByIds(bodyList.getCodes());
    }

    @GetMapping("/getProjects")
    private List<project> getProjectsAll(){
        return commonMethodService.getAllProjects();
    }

}
