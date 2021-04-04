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
 * <p>
 * JwtToken工具类
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/1 11:45
 */
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息生成token
     *
     * @param userDetails
     * @return java.lang.String
     * @author ash
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取用户名
     *
     * @param token Token
     * @return java.lang.String
     * @author ash
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
     * 从token中获取荷载
     *
     * @param token Token
     * @return io.jsonwebtoken.Claims
     * @author ash
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
     * 根据负载生成JWT token
     *
     * @param claims
     * @return java.lang.String
     * @author ash
     */
    private String generateToken(Map<String,Object>claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 生成token失效时间
     *
     * @param
     * @return java.util.Date
     * @author ash
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
    
    /**
     * 验证token是否有效
     *
     * @param token
     * @param userDetails
     * @return boolean
     * @author ash
     */
    public boolean validateToken(String token,UserDetails userDetails){
        String username=getUsernameFromToken(token);
        return username.equals(userDetails.getUsername())&& !isTokenExpired(token);
    }

    /**
     * 判断token是否刷新
     *
     * @param token
     * @return boolean
     * @author ash
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     *
     * @param token
     * @return java.lang.String
     * @author ash
     */
    public String refreshToken(String token){
        Claims claims=getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
     * 判断token是否失效
     *
     * @param token
     * @return boolean
     * @author ash
     */
    private boolean isTokenExpired(String token) {
        Date expireDate =getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获得过期时间
     *
     * @param token
     * @return java.util.Date
     * @author ash
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();
    }
}
