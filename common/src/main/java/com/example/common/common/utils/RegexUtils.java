package com.example.common.common.utils;

import com.google.common.base.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: lanchengx
 * @Date: 2020/7/25 0025
 */
public class RegexUtils {

    /**
     * 邮箱校验
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * ip 格式校验
     * @param ip
     * @return
     */
    public static boolean isIp(String ip) {
        if (Strings.isNullOrEmpty(ip)) {
            return false;
        }

        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        return ip.matches(regex);
    }

    /**
     * 是否包含特殊字符校验
     * @param text
     * @return  true  ：包含
     *          false : 不包含
     */
    public static boolean hasSpecialChar(String text) {
        if (Strings.isNullOrEmpty(text)) {
            return false;
        }

        if (text.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            /*不包含特殊字符*/
            return true;
        }
        return false;
    }


    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点
     * @param text
     * @return
     */
    private static Pattern CHINESE_REGEX = Pattern.compile("[\u4e00-\u9fa5]");
    public static boolean isChinese(String text) {
        if (Strings.isNullOrEmpty(text)) {
            return false;
        }
        Matcher m = CHINESE_REGEX.matcher(text);
        return m.find();
    }

    /**
     * 判断是否为正整数
     * @param number
     * @return
     */
    public static boolean isNumber(String number) {
        if (Strings.isNullOrEmpty(number)) {
            return false;
        }

        String regex = "[0-9]*";
        return number.matches(regex);
    }

    /**
     * 判断几位小数(正数，decimal 数字，count 小数位数)
     * @param decimal
     * @param count
     * @return
     */
    public static boolean isDecimal(String decimal, int count) {
        if (Strings.isNullOrEmpty(decimal)) {
            return false;
        }

        String regex = "^(-)?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){" + count
                + "})?$";
        return decimal.matches(regex);
    }

    /**
     * 判断是否是手机号码
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        if (Strings.isNullOrEmpty(phoneNumber)) {
            return false;
        }

        String regex = "^1\\d{10}$";
        return phoneNumber.matches(regex);
    }

    /**
     * 验证URL地址
     * @param url
     * @return
     */
    public static boolean checkURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }


    /**
     * 匹配中国邮政编码
     * @param postcode
     * @return
     */
    public static boolean checkPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }
}
