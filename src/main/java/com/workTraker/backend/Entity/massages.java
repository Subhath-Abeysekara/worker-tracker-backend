package com.workTraker.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class massages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msgId;
    private String massage;
    private Long senderId;
    private Long meetingId;
    private Long receiverId;


    public massages() {
    }
}
