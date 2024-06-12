package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.model.CommentsEntity;
import com.evaluation.bankProperty.model.dto.CommentsDto;
import com.evaluation.bankProperty.repository.CommentsRepository;
import com.evaluation.bankProperty.service.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentsServiceImpl implements ICommentsService {
    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository _commentsRepository){
        commentsRepository = _commentsRepository;
    }

    @Override
    public CommentsEntity save(CommentsDto commentsDto) {
        return commentsRepository.save(commentsDto);
    }
}
