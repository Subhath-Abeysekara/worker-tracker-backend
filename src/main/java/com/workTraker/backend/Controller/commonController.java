package com.workTraker.backend.Controller;

import com.workTraker.backend.Entity.employee;
import com.workTraker.backend.Entity.meeting;
import com.workTraker.backend.Entity.meetingAddBody;
import com.workTraker.backend.Entity.request;
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

}
