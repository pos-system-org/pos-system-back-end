package com.pos_system.pos_system.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class StandardResponse {
    private String message;
    private int code;
    private Object data;

    public StandardResponse(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data=data;
    }

    public StandardResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
