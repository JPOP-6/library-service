package com.library.service.system.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity
@Table(name = "LIBRARY")
@Data
@FieldNameConstants
public class Library {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "BOOK_ID")
    private int bookId;

}
