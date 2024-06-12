package com.evaluation.bankProperty.service;

import com.evaluation.bankProperty.bean.UsersBean;
import com.evaluation.bankProperty.model.UsersEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
    UsersEntity getByLoginAndPassword(String login, String password) throws UsernameNotFoundException;
    UsersEntity save(UsersBean usersBean);
    UsersEntity usersBeanToEntity(UsersBean usersBean);
}
