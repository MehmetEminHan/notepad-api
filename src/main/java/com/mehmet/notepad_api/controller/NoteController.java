package com.mehmet.notepad_api.controller;

import com.mehmet.notepad_api.model.NoteEntity;
import com.mehmet.notepad_api.model.Response;
import com.mehmet.notepad_api.services.NoteService;
import com.mehmet.notepad_api.services.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/note")
public class NoteController extends ResponseService {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity saved", noteService.addNote(noteEntity)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable Integer id) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity deleted\\nNoteEntity id: \"" + id, noteService.deleteNote(id)));
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> updateNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(createCustomResponse("Successful", "NoteEntity updated", noteService.editNote(noteEntity)));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Response> getAllNotes() {
        return ResponseEntity.ok(createCustomResponse("Successful", "Notes", noteService.getAllNotes()));
    }

    @GetMapping("/get-all-edits")
    public ResponseEntity<Response> getAllEditedNotes() {
        return ResponseEntity.ok(createCustomResponse("Successful", "Notes", noteService.getAllEdits()));
    }
}
