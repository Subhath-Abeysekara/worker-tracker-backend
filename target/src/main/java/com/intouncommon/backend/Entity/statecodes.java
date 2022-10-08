package com.intouncommon.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class statecodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
    private String state_type;
    private String repayColor = "red";
    private String changeColor = "red";
    private String warrantyColor = "red";
    private String discountColor="red";


    public statecodes() {
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getState_type() {
        return state_type;
    }

    public void setState_type(String state_type) {
        this.state_type = state_type;
    }
}
