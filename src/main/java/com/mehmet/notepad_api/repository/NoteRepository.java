package com.mehmet.notepad_api.repository;

import com.mehmet.notepad_api.model.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {
    List<NoteEntity> findByTitle(String title);
}
