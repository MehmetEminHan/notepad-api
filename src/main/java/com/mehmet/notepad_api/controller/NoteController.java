package com.mehmet.notepad_api.controller;

import com.mehmet.notepad_api.model.NoteEntity;
import com.mehmet.notepad_api.model.Response;
import com.mehmet.notepad_api.services.NoteService;
import com.mehmet.notepad_api.utils.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/note")
@AllArgsConstructor
public class NoteController{

    private final NoteService noteService;

    private static final String SUCCESSFUL = "Successful";
    private static final String NOTE_SAVED = "Note saved!";
    private static final String NOTE_DELETED = "NoteEntity deleted\\nNoteEntity id: \"";
    private static final String NOTE_UPDATED = "Note updated!";
    private static final String ALL_NOTES = "All notes returned!";
    private static final String ALL_EDITS = "All edits returned!";

    @PostMapping("/save")
    public ResponseEntity<Response> saveNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(ResponseUtil.getResponse(SUCCESSFUL, NOTE_SAVED, noteService.addNote(noteEntity)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable Integer id) {
        return ResponseEntity.ok(ResponseUtil.getResponse(SUCCESSFUL, NOTE_DELETED + id, noteService.deleteNote(id)));
    }

    @PutMapping("/edit")
    public ResponseEntity<Response> updateNote(@RequestBody NoteEntity noteEntity) {
        return ResponseEntity.ok(ResponseUtil.getResponse(SUCCESSFUL, NOTE_UPDATED, noteService.editNote(noteEntity)));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Response> getAllNotes() {
        return ResponseEntity.ok(ResponseUtil.getResponse(SUCCESSFUL, ALL_NOTES, noteService.getAllNotes()));
    }

    @GetMapping("/get-all-edits")
    public ResponseEntity<Response> getAllEditedNotes() {
        return ResponseEntity.ok(ResponseUtil.getResponse(SUCCESSFUL, ALL_EDITS, noteService.getAllEdits()));
    }
}
