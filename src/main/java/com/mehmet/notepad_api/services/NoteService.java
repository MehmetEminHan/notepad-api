package com.mehmet.notepad_api.services;

import com.mehmet.notepad_api.model.Note;
import com.mehmet.notepad_api.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note addNote(Note note) {
        note.setAuthor(System.getProperty("user.name"));
        return noteRepository.save(note);
    }
}


