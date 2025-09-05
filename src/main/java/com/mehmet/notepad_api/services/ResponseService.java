package com.mehmet.notepad_api.services;

import com.mehmet.notepad_api.model.Response;

public class ResponseService {

    public Response createCustomResponse(String status, String message, Object data) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);

        return response;
    }
}
