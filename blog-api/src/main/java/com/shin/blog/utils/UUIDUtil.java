package com.shin.blog.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDUtil {
    public static String creatUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //生成六位随机正整数
    public static Long creatLong() {
        Random random = new Random();
        String str = String.valueOf(random.nextInt(9) + 1);
        for (int i = 0; i < 5; i++) {
            str += random.nextInt(10);
        }
        Long num = Long.valueOf(str);
        return num;
    }

    public static void main(String[] args) {
        System.out.println("6位随机数： "+creatLong());
    }
}
