package com.intouncommon.backend.Entity;

import lombok.Data;

@Data
public class response {

    String response;

    public response() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
