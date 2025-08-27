package com.mehmet.notepad_api.rest;

import com.mehmet.notepad_api.model.Note;
import com.mehmet.notepad_api.model.Response;
import com.mehmet.notepad_api.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/saveNote")
    public Response saveNote(@RequestBody Note note) {

        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Note saved");
        response.setData(noteService.addNote(note));

        return response;


    }
}
