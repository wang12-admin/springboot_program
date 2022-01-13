package com.javacode.springboot_program.utils;

import com.javacode.springboot_program.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT
 * 根据用户信息自动生成token令牌
 *
 * @author shkstart
 * @create 2022-01-08 21:36
 */
public class JWTUtil {
    private final static long EXPIRE = 60000 * 60 * 24 * 7; //过期时间一周7天
    private static final String SECRET = "adminJava"; //秘钥
    private final static String TOKEN_PREFIX = "WANG";  //令牌前缀
    private final static String SUBJECT = "JAVA"; //主题版权

    /**
     * 根据用户信息生成令牌
     *
     * @param user
     * @return
     */
    public static String geneToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("header_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date()) //发行时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) //过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET) //秘钥签名
                .compact();
        token = TOKEN_PREFIX + token;
        return token;

    }

    /**
     * token令牌解密
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            //如果没有解密成功就返回null就行了
            return null;
        }
    }


}
