package com.ash.server.config.security.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description JwtToken工具类
 * @Author ash
 * @Date 2021/1/26 20:27
 * @Version 1.0
 **/
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /** 
     * @Description: 根据用户信息生成token 
     * @Param: [userDetails] 
     * @Return: java.lang.String 
     * @Author ash
     * @Date: 22:05 2021/1/26
     */ 
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /** 
     * @Description: 从token中获取用户名 
     * @Param: [token] 
     * @Return: java.lang.String 
     * @Author ash
     * @Date: 22:05 2021/1/26
     */ 
    public String getUsernameFromToken(String token){
        String username;
        try {
            Claims claims=getClaimsFromToken(token);
            username=claims.getSubject();
        } catch (Exception e) {
            username=null;
        }
        return username;
    }

    /** 
     * @Description: 从token中获取荷载 
     * @Param: [token] 
     * @Return: io.jsonwebtoken.Claims 
     * @Author ash
     * @Date: 22:05 2021/1/26
     */ 
    private Claims getClaimsFromToken(String token) {
        Claims claims=null;
        try {
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /** 
     * @Description: 根据负载生成JWT token 
     * @Param: [claims] 
     * @Return: java.lang.String 
     * @Author ash
     * @Date: 22:05 2021/1/26
     */ 
    private String generateToken(Map<String,Object>claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /** 
     * @Description: 生成token失效时间 
     * @Param: [] 
     * @Return: java.util.Date 
     * @Author ash
     * @Date: 22:05 2021/1/26
     */ 
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
    
    /**
     * @Description: 验证token是否有效
     * @Param: [token, userDetails]
     * @Return: boolean
     * @Author ash
     * @Date: 22:06 2021/1/26
     */
    public boolean validateToken(String token,UserDetails userDetails){
        String username=getUsernameFromToken(token);
        return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
    }

    /** 
     * @Description: 判断token是否刷新
     * @Param: [token] 
     * @Return: boolean 
     * @Author ash
     * @Date: 22:11 2021/1/26
     */ 
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /** 
     * @Description: 刷新token
     * @Param: [token] 
     * @Return: java.lang.String 
     * @Author ash
     * @Date: 22:14 2021/1/26
     */ 
    public String refreshToken(String token){
        Claims claims=getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
     * @Description: 判断token是否失效
     * @Param: [token]
     * @Return: boolean
     * @Author ash
     * @Date: 22:06 2021/1/26
     */
    private boolean isTokenExpired(String token) {
        Date expireDate =getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /** 
     * @Description: 从token中获得过期时间 
     * @Param: [token] 
     * @Return: java.util.Date 
     * @Author ash
     * @Date: 22:08 2021/1/26
     */ 
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();
    }
}
