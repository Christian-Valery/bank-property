package com.evaluation.bankProperty.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name="uploadeddocument")
public class UploadedDocumentEntity {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduploadeddocument")
    private int idUploadedDocument;

    @ManyToOne
    @JoinColumn(name = "fk_documenttype_id")
    private DocumentTypeEntity documentTypeEntity;

    @Column(name = "documentfilename")
    private String documentFileName;

    @Column(name = "documentsizevalue")
    private double documentSizeValue;

    @Column(name = "documentsizetermination")
    private String documentSizeTermination;

    @ManyToOne
    @JoinColumn(name = "fk_usersuploader_id")
    private UsersEntity usersEntityUploader;

    @Column(name = "uploadingdate")
    //private ZonedDateTime createdDate = ZonedDateTime.now(ZoneId.of("UTC+3"));
    private ZonedDateTime uploadingDate;
}
