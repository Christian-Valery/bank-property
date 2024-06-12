package com.evaluation.bankProperty.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;


public interface ConstantUtils {

    public int DOSSIER_ETAT_ATTENTE_INTERMEDIAIRE = 0;
    public int DOSSIER_ETAT_ATTENTE_ADMIN = 1;
    public int DOSSIER_ETAT_VALIDE = 2;
    public int ID_VALIDEUR_INTERMEDIAIRE = 21;

    // SOCIETE TOUTES
    public String CODE_SOCIETE_TOUTES = "TOUTES";


    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    public static final Key SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String[] URL_PERMIT_ALL = new String[]{"/patrimoine/users/login","/patrimoine/dossier/exportsearchc","/patrimoine/piecejointe/download","/patrimoine/upload","/patrimoine/uploadPJ"};
}
