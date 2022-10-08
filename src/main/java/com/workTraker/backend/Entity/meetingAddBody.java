package com.workTraker.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class meetingAddBody {

    private meeting meeting;
    private List<Long> employees;

    public meetingAddBody() {
    }
}
