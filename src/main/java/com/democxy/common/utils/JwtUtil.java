package com.democxy.common.utils;

import com.alibaba.fastjson.JSON;
import com.democxy.modules.sys.entity.Account;
import io.jsonwebtoken.*;
import java.util.Date;

/**
 * @author SHILING_DENG
 * @version 2020-05-05
 *
 */
public class JwtUtil {


    /**
     * 设置过期时间为60分钟
     */
    public static final long EXPIRE_TIME = 60*60;


    public static final String REDIS_KEY_PREFIX = "JWT:";
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "6CvvNscuUDAq*JxE";

    /**
     * 签发JWT
     * @param id 可以设置为登录账户的ID
     * @param subject 可以是JSON数据,如登录用户的JSON字符串 尽可能少
     * @param ttlMillis token有效时间
     * @return
     */
    public static String signToken(String id, String subject, long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                // 主题
                .setSubject(subject)
                // 签发者
                .setIssuer("admin")
                // 签发时间
                .setIssuedAt(now)
                // 签名算法以及密匙
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis*1000;
            Date expDate = new Date(expMillis);
            // 过期时间
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    public static String reflashToken(Account account, long ttlMillis){
        return signToken(account.getAccountId(), JSON.toJSONString(account),ttlMillis);
    }

    /**
     * 验证JWT
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        try {
            Claims claims = parseToken(token);
            if (claims!=null){
                return true;
            }else{
                return false;
            }

        } catch (ExpiredJwtException e) {
           return false;
        } catch (SignatureException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }



    /**
     * 解析JWT字符串
     * @param token
     * @return
     * @throws Exception
     */
    public static Claims parseToken(String token){
        Claims body = null;
        try {
            body = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void main(String[] args){
        String token = signToken("1", "admin", EXPIRE_TIME);
        System.out.println(token);
        System.out.println(validateToken(token));
        System.out.println(parseToken(token).getSubject());
    }
}
