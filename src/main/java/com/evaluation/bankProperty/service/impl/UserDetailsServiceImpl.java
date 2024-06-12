package com.evaluation.bankProperty.service.impl;

import com.evaluation.bankProperty.bean.UsersBean;
import com.evaluation.bankProperty.model.UsersEntity;
import com.evaluation.bankProperty.repository.UserRepository;
import com.evaluation.bankProperty.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with name: " + username+" not found" );
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
    }


    @Override
    public UsersEntity getByLoginAndPassword(String login, String password) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByLoginAndPassword(login, password);
        if(usersEntity == null)
            throw new UsernameNotFoundException("User with login " +login+" not found");
        return usersEntity;
    }

    @Override
    public UsersEntity save(UsersBean usersBean) {
        return userRepository.save(usersBeanToEntity(usersBean));
    }

    @Override
    public UsersEntity usersBeanToEntity(UsersBean usersBean){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(usersBean.getLogin());
        usersEntity.setPassword(usersBean.getPassword());
        usersEntity.setName(usersBean.getName());
        usersEntity.setBusinessUnit(usersBean.getBusinessUnit());
        usersEntity.setContactNumber(usersBean.getContactNumber());
        return usersEntity;
    }
}
