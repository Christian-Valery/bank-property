package com.evaluation.bankProperty.model.dto;

import com.evaluation.bankProperty.model.UsersEntity;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CommentsDto {
    private String commentContent;
    private ZonedDateTime createdDate;
    private UsersEntity usersEntity;
}
