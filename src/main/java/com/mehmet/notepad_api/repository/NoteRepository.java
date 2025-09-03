package com.mehmet.notepad_api.repository;

import com.mehmet.notepad_api.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
