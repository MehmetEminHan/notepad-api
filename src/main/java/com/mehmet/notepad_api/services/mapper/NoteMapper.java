package com.mehmet.notepad_api.services.mapper;

import com.mehmet.notepad_api.model.NoteDTO;
import com.mehmet.notepad_api.model.NoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteEntity dtoToEntity(NoteDTO noteDTO);
    NoteDTO entityToDto(NoteEntity note);
}

