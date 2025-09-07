package com.mehmet.notepad_api.repository;

import com.mehmet.notepad_api.model.EditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EditRepository extends JpaRepository<EditEntity, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM edit where linknum = ?1", nativeQuery = true)
    void deleteByLinknum (Integer linknum);
}
