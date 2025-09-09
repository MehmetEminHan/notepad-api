package com.mehmet.notepad_api.model;

import lombok.Getter;


@Getter
public class NoteDTO {
    public String title;
    public String content;
    private String author = System.getProperty("user.name");

    public NoteDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
