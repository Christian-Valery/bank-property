package com.evaluation.bankProperty.bean;

import lombok.Data;

@Data
public class UsersToken {
    private String token;
    private UsersBean utilisateurBean;
    public UsersToken(String token, UsersBean utilisateurBean) {
        this.token = token;
        this.utilisateurBean = utilisateurBean;
    }

}
