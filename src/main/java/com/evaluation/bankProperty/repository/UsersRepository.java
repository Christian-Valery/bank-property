package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByLoginAndPassword(String login, String password);
}
