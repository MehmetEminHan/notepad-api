package com.mehmet.notepad_api.services;

import com.mehmet.notepad_api.model.EditEntity;
import com.mehmet.notepad_api.model.NoteEntity;
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

    public NoteEntity addNote(NoteEntity noteEntity) {
        noteEntity.setAuthor(System.getProperty("user.name"));
        return noteRepository.save(noteEntity);
    }

    public String deleteNote(Integer Id) {
        editRepository.deleteByLinknum(Id);
        noteRepository.deleteById(Id);
        return "NoteEntity deleted";
    }

    public NoteEntity editNote(NoteEntity noteEntity) {
        EditEntity editEntity = new EditEntity();

        editEntity.setLinknum(noteRepository.findById(noteEntity.getId()).get().getId());
        editEntity.setEditedBy(System.getProperty("user.name"));
        editEntity.setBeforeEdit(noteRepository.findById(noteEntity.getId()).get().getContent());
        editEntity.setAfterEdit(noteEntity.getContent());
        editEntity.setEditDate(new Date());

        noteRepository.findById(noteEntity.getId()).get().setContent(noteEntity.getContent());

        noteRepository.save(noteRepository.findById(noteEntity.getId()).get());
        editRepository.save(editEntity);

        return noteRepository.findById(noteEntity.getId()).get();
    }

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<EditEntity> getAllEdits() {
        return editRepository.findAll();
    }
}


