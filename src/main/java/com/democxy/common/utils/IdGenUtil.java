package com.democxy.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * ID工具类
 *
 * @author shiling_deng
 */
public class IdGenUtil {

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getRandomCharAndNumr(Integer length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            boolean b = random.nextBoolean();
            if (b) {
                // 字符串
                // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
                // 取得大写字母
                str += (char) (65 + random.nextInt(26));
            } else {
                // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }


    public static String getRandomNumr() {
        return System.currentTimeMillis() + "" + (int) ((Math.random() * 9 + 1) * 1000);
    }

    public static void main(String[] args) {
        System.out.println(getRandomCharAndNumr(5));
        System.out.println(getRandomNumr());
        System.out.println(getUUID());
    }

}
