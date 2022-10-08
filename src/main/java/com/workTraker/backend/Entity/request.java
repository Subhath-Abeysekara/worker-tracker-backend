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
public class request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reqId;
    private Long sender_id;
    private Long receiver_id;
    private String acceptStatus="pending";

    public request() {
    }
}
