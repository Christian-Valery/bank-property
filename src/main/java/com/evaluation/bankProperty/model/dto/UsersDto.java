package com.evaluation.bankProperty.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UsersDto {

    private String login;
    private String password;
    @Override
    public String toString(){
        return "LoginDTO{" +
                "login='" + login + '\'' +
                ", password='*****'}'";
    }
}
