package com.evaluation.bankProperty.dao.impl;

import com.evaluation.bankProperty.dao.IUsersDao;
import com.evaluation.bankProperty.model.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersDao implements IUsersDao {

    private IUsersDao usersDao;

    @Autowired
    public UsersDao(IUsersDao _usersDao){
        this.usersDao = _usersDao;
    }
    @Override
    public List<Object[]> getAll() {
        return null;
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return null;
    }

    @Override
    public UsersEntity getById(int usersId) {
        return null;
    }

    @Override
    public UsersEntity getByLogin(String login) {
        return null;
    }

    @Override
    public UsersEntity create(UsersEntity user) {
        return null;
    }

    @Override
    public void update(UsersEntity user) {

    }

    @Override
    public void changePassword(UsersEntity user) {

    }

    @Override
    public void delete(int utilisateurId) {

    }

    @Override
    public void resetPassword(UsersEntity user) {

    }
}
