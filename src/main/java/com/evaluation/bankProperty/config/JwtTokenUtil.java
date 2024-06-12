package com.evaluation.bankProperty.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    public static final long JWT_TOKEN_VALIDITY = 60L * 60L;
    private static final Logger log = LogManager.getLogger(JwtTokenUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    //retrieve code client from jwt token
    public String getClientIdFromToken(String token) throws SignatureException {
        return getClaimFromToken(token, Claims::getId);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) throws SignatureException {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws SignatureException {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) throws SignatureException {
        return Jwts.parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    //check if the token has expired
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails senderEntity) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, senderEntity);
    }

    //creating token
    private String doGenerateToken(Map<String, Object> claims, UserDetails userDetails) {
        log.info("Génération du token");
        //le clientId est stocké au sein du userDetails.getUsername()
        return Jwts
                .builder()
                .setClaims(claims)
                .setId(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 12000)) // durée de vie du token : 12h
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String code = getClientIdFromToken(token);
        return (code.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // encrypt password
    public String encryptMdp(String mdp) {
        String encoded = "";
        log.info("Encodage du mdp");
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mdp.getBytes(StandardCharsets.US_ASCII));
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            encoded = new String( Base64.getEncoder().encode(hexString.toString().getBytes()) );
        }catch(Exception e){
            encoded="";
        }
        log.info("Encodage terminé");
        return encoded;
    }
}
