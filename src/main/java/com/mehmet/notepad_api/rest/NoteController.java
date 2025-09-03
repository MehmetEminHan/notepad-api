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
    public ResponseEntity<Response> saveNote(@RequestBody Note note) {
        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Note saved");
        response.setData(noteService.addNote(note));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteNote/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable Integer id) {
        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Note deleted\nNote id: " + id);
        response.setData(noteService.deleteNote(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/editNote")
    public ResponseEntity<Response> updateNote(@RequestBody Note note) {
        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Note updated");
        response.setData(noteService.editNote(note));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllNotes")
    public ResponseEntity<Response> getAllNotes() {
        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Notes");
        response.setData(noteService.getAllNotes());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllEditedNotes")
    public ResponseEntity<Response> getAllEditedNotes() {
        Response response = new Response();
        response.setStatus("Successful");
        response.setMessage("Edited Notes: ");
        response.setData(noteService.getAllEdits());
        return ResponseEntity.ok(response);
    }
}
