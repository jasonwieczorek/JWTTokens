package j.m.w.scratchclasses;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import j.m.w.components.JwtTokenUtil;

/**
 * A sample JWT Token reader, all we need is a secret!
 */
public class JWTTokenParser {

    final static String secretKey = "supersecretkey";

    final static String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKYXNvbiIsImV4cCI6MTU3NDA2MDk4NSwiaWF0IjoxNTc0MDQyOTg1fQ.RaFl74YYMqHNy_r8I4haznT-vlA6DQusPoEqnr7dV3Ut989vp4EZsltb8u2wAd9BCEjC4Bk-n6jRCmVxV74HHg";

    public static void main(String[] args) {
        JwtTokenUtil tokenUtil = new JwtTokenUtil();
        tokenUtil.setSecret(secretKey);
        Claims claims = tokenUtil.getAllClaimsFromToken(token);
        System.out.println(claims);

    }


}
