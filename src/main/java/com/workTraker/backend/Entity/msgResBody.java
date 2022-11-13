package com.workTraker.backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class msgResBody {

    private String massage;
    private String senderName;
    private String receiverName;
}
