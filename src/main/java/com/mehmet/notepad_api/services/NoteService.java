package com.mehmet.notepad_api.services;

import com.mehmet.notepad_api.model.Edit;
import com.mehmet.notepad_api.model.Note;
import com.mehmet.notepad_api.repository.EditRepository;
import com.mehmet.notepad_api.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final EditRepository editRepository;

    public NoteService(NoteRepository noteRepository, EditRepository editRepository) {
        this.noteRepository = noteRepository;
        this.editRepository = editRepository;
    }

    public Note addNote(Note note) {
        note.setAuthor(System.getProperty("user.name"));
        return noteRepository.save(note);
    }

    public String deleteNote(Integer Id) {
        editRepository.deleteByLinknum(Id);
        noteRepository.deleteById(Id);
        return "Note deleted";
    }

    public Note editNote(Note note) {
        Edit edit = new Edit();

        edit.setLinknum(noteRepository.findById(note.getId()).get().getId());
        edit.setEditedBy(System.getProperty("user.name"));
        edit.setBeforeEdit(noteRepository.findById(note.getId()).get().getContent());
        edit.setAfterEdit(note.getContent());
        edit.setEditDate(new Date());

        noteRepository.findById(note.getId()).get().setContent(note.getContent());

        noteRepository.save(noteRepository.findById(note.getId()).get());
        editRepository.save(edit);

        return noteRepository.findById(note.getId()).get();
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Edit> getAllEdits() {
        return editRepository.findAll();
    }
}


