package com.evaluation.bankProperty.repository;

import com.evaluation.bankProperty.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findByName(String name);
    UsersEntity findByLoginAndPassword(String login, String password);
}
