package com.evaluation.bankProperty.dao;

import com.evaluation.bankProperty.model.UsersEntity;

import java.util.List;

public interface IUsersDao {

    List<Object[]> getAll();
    List<UsersEntity> getAllUsers();

    UsersEntity getById(int usersId);
    UsersEntity getByLogin(String login);


    UsersEntity create(UsersEntity user);
    void update (UsersEntity user);
    void changePassword (UsersEntity user);
    void delete (int utilisateurId);
    void resetPassword(UsersEntity user);
}
