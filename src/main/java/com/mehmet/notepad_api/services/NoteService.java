package com.mehmet.notepad_api.services;

import com.mehmet.notepad_api.model.NoteDTO;
import com.mehmet.notepad_api.model.NoteEntity;
import com.mehmet.notepad_api.repository.NoteRepository;
import com.mehmet.notepad_api.services.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public NoteEntity addNote(NoteDTO noteDTO) {
        return noteRepository.save(noteMapper.dtoToEntity(noteDTO));
    }

    public String deleteNote(Integer Id) {
        noteRepository.deleteById(Id);
        return "NoteEntity deleted";
    }

    public List<NoteDTO> editNote(NoteDTO noteDTO) {
        List<NoteEntity> noteEntityList = noteRepository.findByTitle(noteMapper.dtoToEntity(noteDTO).getTitle());
        List<NoteDTO> noteDTOList = new ArrayList<>();
        for (NoteEntity noteEntity : noteEntityList) {
            noteEntity.setContent(noteDTO.getContent());
            noteRepository.save(noteEntity);
            noteDTOList.add(noteMapper.entityToDto(noteEntity));
        }
        return noteDTOList;
    }

    public List<NoteDTO> getAllNotes() {
        List<NoteDTO> noteDTOList = new ArrayList<>();
        noteRepository.findAll().forEach(note -> noteDTOList.add(noteMapper.entityToDto(note)));
        return noteDTOList;
    }
}


