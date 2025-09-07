package com.mehmet.notepad_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
public class Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int linknum;
    private Date editDate;
    private String editedBy;
    private String beforeEdit;
    private String afterEdit;
    private String editReason;
}
