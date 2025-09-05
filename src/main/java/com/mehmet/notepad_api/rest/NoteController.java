package com.mehmet.notepad_api.rest;

import com.mehmet.notepad_api.model.Note;
import com.mehmet.notepad_api.model.Response;
import com.mehmet.notepad_api.services.NoteService;
import com.mehmet.notepad_api.services.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class NoteController extends ResponseService {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/saveNote")
    public ResponseEntity<Response> saveNote(@RequestBody Note note) {
        return ResponseEntity.ok(createCustomResponse("Successful", "Note saved", noteService.addNote(note)));
    }

    @DeleteMapping("/deleteNote/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable Integer id) {
        return ResponseEntity.ok(createCustomResponse("Successful", "Note deleted\\nNote id: \"" + id, noteService.deleteNote(id)));
    }

    @PostMapping("/editNote")
    public ResponseEntity<Response> updateNote(@RequestBody Note note) {
        return ResponseEntity.ok(createCustomResponse("Successful", "Note updated", noteService.editNote(note)));
    }

    @GetMapping("/getAllNotes")
    public ResponseEntity<Response> getAllNotes() {
        return ResponseEntity.ok(createCustomResponse("Successful", "Notes", noteService.getAllNotes()));
    }

    @GetMapping("/getAllEditedNotes")
    public ResponseEntity<Response> getAllEditedNotes() {
        return ResponseEntity.ok(createCustomResponse("Successful", "Notes", noteService.getAllEdits()));
    }
}
