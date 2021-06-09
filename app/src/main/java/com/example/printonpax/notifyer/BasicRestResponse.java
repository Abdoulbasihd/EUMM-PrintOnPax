package com.example.printonpax.notifyer;

import java.io.Serializable;

public class BasicRestResponse implements Serializable {
    private int code;
    private String message;
    private String status;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
