package com.br.var.solutions.infraestructure.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionID = 9401650691232133L;

    public static final long JWT_TOKEN_EXPIRES = 1800000;

    private String secret = "24d4b539cae8cb198c330e9d19d979e5b47bd7a33c2616ca849ac74342ece639f73efa35ca6f3aecd4b125ac741211ff4d79611f5f550a86deebc3605bb17424";

    //retornar o username do token do JWT

    public String getUsernameFronToken(String token){
        return getClaimFronToken(token, Claims::getSubject);
    }

    //Retorna varios objetos possiveis de varios tipos possiveis. - captura as informaç~~oes de dentro do token.

    public <T> T getClaimFronToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFronToken(token);
    return  claimsResolver.apply(claims);

    }

    //retorna expiration date do token jwt
    public Date getExpirationDateFronToken(String token){
        return getClaimFronToken(token, Claims::getExpiration);

    }

    //Para retorna qualquer informação do token e para isso nos vamos precisar da secret.


    private Claims getAllClaimsFronToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }



    //validar se o token é expirado.
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFronToken(token);
       return expiration.before(new Date());
    }

    //Gerar Token
    public String generateToken(String clientId){
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, clientId);
    }

    // cria o token e tambem vai definir o tempo de expiração.
    private String doGenerateToken(Map<String, Object> claims, String clientId) {
       return Jwts.builder().setClaims(claims)
               .setSubject(clientId).setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRES ))
               .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
     //validar o token
    public Boolean validarToken(String token, UserDetails userDetails){
        final String username = getUsernameFronToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }




}
