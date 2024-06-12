package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.CommentsEntity;
import com.evaluation.bankProperty.model.dto.CommentsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Integer> {
    CommentsEntity save(CommentsDto commentsDto);
}
