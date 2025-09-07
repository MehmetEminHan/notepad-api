package com.mehmet.notepad_api.utils;

import com.mehmet.notepad_api.model.Response;

public class ResponseUtil {

    public static Response getResponse(String status, String message, Object data) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);

        return response;
    }
}
