package com.example.common.common.utils;

import java.text.MessageFormat;

/**
 * @Author: lanchengx
 * @Date: 2020/7/25 0025
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String format(String message, Object...obs){
        return MessageFormat.format("您好{0}，晚上好！您目前余额：{1,number,#.##}元，积分：{2}", "张三", 10.155, 10);
    }
}
