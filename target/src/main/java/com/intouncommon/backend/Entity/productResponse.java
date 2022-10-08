package com.intouncommon.backend.Entity;

import lombok.Data;

import java.util.List;

@Data
public class productResponse {

    private List<productions> productions;
    private String contact;

    public productResponse() {
    }

    public List<com.intouncommon.backend.Entity.productions> getProductions() {
        return productions;
    }

    public void setProductions(List<com.intouncommon.backend.Entity.productions> productions) {
        this.productions = productions;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
