package com.mehmet.notepad_api.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String status;
    private String message;
    private Object data;
}
