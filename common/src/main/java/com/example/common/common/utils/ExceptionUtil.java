package com.example.common.common.utils;

import cn.hutool.core.lang.Assert;
import com.example.common.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lanchengx
 * @Date: 2020/7/25 0025
 */
public class ExceptionUtil extends cn.hutool.core.exceptions.ExceptionUtil {

    private static Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);


    /**
     *  MessageFormat.format("您好{}，晚上好！您目前余额：{}元，积分：{}", "张三", 10.155, 10)
     * @param throwable
     * @param code
     * @param message
     * @param objs
     * @return 您好张三，晚上好！您目前余额：10.155元，积分：10
     */
    public static RuntimeException newServiceException(Throwable throwable, Integer code, String message, Object...objs) {
        String format = StringUtil.format(message, objs);
        logger.error(message, throwable);
        return new ServiceException(code, format, throwable);
    }


    public static RuntimeException newServiceException(Integer code, String message, Object...objs) {
        String format = StringUtil.format(message, objs);
        logger.error(message);
        return new ServiceException(code, format);
    }

    public static RuntimeException newServiceException(Throwable throwable, String message, Object...objs) {
        String format = StringUtil.format(message, objs);
        logger.error(message, throwable);
        return new ServiceException(format, throwable);
    }

    public static RuntimeException newServiceException(String message, Object...objs) {
        String format = StringUtil.format(message, objs);
        logger.error(message);
        return new ServiceException(format);
    }

    public static RuntimeException newServiceException(Throwable throwable) {
        logger.error(throwable.getMessage());
        return new ServiceException(throwable);
    }


}
