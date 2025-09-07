package com.mehmet.notepad_api.rest;

import com.mehmet.notepad_api.model.NoteEntity;
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
    public ResponseEntity<Response> saveNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity saved", noteService.addNote(noteEntity)));
    }

    @DeleteMapping("/deleteNote/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable Integer id) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity deleted\\nNoteEntity id: \"" + id, noteService.deleteNote(id)));
    }

    @PostMapping("/editNote")
    public ResponseEntity<Response> updateNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity updated", noteService.editNote(noteEntity)));
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
