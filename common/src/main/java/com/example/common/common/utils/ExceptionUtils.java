package com.example.common.common.utils;

import com.example.common.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * @Author: lanchengx
 * @Date: 2020/7/25 0025
 */
public class ExceptionUtils {

    private static Logger logger = LoggerFactory.getLogger(ExceptionUtils.class);


    /**
     *  MessageFormat.format("您好{0}，晚上好！您目前余额：{1,number,#.##}元，积分：{2}", "张三", 10.155, 10)
     * @param throwable
     * @param code
     * @param message
     * @param strings
     * @return 您好张三，晚上好！您目前余额：10.16元，积分：10
     */
    public static RuntimeException newServiceException(Throwable throwable, Integer code, String message, String...strings) {
        String format = MessageFormat.format(message, strings);
        logger.error(message, throwable);
        return new ServiceException(code, format, throwable);
    }


    public static RuntimeException newServiceException(Integer code, String message, String...strings) {
        String format = MessageFormat.format(message, strings);
        logger.error(message);
        return new ServiceException(code, format);
    }

    public static RuntimeException newServiceException(Throwable throwable, String message, String...strings) {
        String format = MessageFormat.format(message, strings);
        logger.error(message, throwable);
        return new ServiceException(format, throwable);
    }

    public static RuntimeException newServiceException(String message, String...strings) {
        String format = MessageFormat.format(message, strings);
        logger.error(message);
        return new ServiceException(format);
    }

    public static RuntimeException newServiceException(Throwable throwable) {
        logger.error(throwable.getMessage());
        return new ServiceException(throwable);
    }


}
