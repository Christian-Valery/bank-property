package com.evaluation.bankProperty.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class UsersBean {

    private int usersId;
    private String login;
    private String password;
    private String name;
    private String businessUnit;
    private String contactNumber;

    public UsersBean(String login, String password, String name, String businessUnit, String contactNumber) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.businessUnit = businessUnit;
        this.contactNumber = contactNumber;
    }

    public UsersBean( String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UsersBean(int usersId, String login, String password) {
        this.usersId = usersId;
        this.login = login;
        this.password = password;
    }

    public UsersBean(int usersId, String login, String password, String name, String businessUnit, String contactNumber) {
        this.usersId = usersId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.businessUnit = businessUnit;
        this.contactNumber = contactNumber;
    }




    @Override
    public String toString() {
        return "LoginBean{" +
                "login='" + login + '\'' +
                ", password='*****'}'";
    }
}
