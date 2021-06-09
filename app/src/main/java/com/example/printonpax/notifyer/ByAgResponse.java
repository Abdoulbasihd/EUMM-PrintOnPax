package com.example.printonpax.notifyer;

import java.io.Serializable;

public class ByAgResponse extends BasicRestResponse implements Serializable {
    AgResponse data;

    public AgResponse getData() {
        return data;
    }

    public void setData(AgResponse data) {
        this.data = data;
    }
}
