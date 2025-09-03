package com.mehmet.notepad_api.repository;

import com.mehmet.notepad_api.model.Edit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditRepository extends JpaRepository<Edit, Integer> {
}
