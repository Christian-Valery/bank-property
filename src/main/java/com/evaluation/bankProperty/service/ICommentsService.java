package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.model.CommentsEntity;
import com.evaluation.bankProperty.model.dto.CommentsDto;
import org.springframework.stereotype.Service;

@Service
public interface ICommentsService {
    CommentsEntity save(CommentsDto commentsDto);
}
