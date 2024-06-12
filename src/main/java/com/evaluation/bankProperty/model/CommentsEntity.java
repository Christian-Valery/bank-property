package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "comments")
public class CommentsEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcomments")
    private int idComments;

    @Column(name = "commentcontent")
    private String commentContent;

    @Column(name = "createddate")
    //private ZonedDateTime createdDate = ZonedDateTime.now(ZoneId.of("UTC+3"));
    private ZonedDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "fk_users_id")
    private UsersEntity usersEntity;
}
