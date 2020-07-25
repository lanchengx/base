package com.example.common.common.utils;

import java.util.UUID;

/**
 * @Author: lanchengx
 * @Date: 2020/7/25 0025
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
