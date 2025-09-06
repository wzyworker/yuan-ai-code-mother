package com.wzy.yuanaicodemother.exception;

/**
 * @author wzy
 * @date 2025年09月06日 22:35
 * 异常处理工具类，为了更方便的抛出异常
 */
public class ThrowUtils {

    /**
     * 条件成立，抛出异常
     *
     * @param condition        条件
     * @param runtimeException 异常
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立，抛出异常
     *
     * @param condition 条件
     * @param errorCode 错误码（错误码和码值都源自枚举）
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立抛异常
     *
     * @param condition 条件
     * @param errorCode 指定错误码(源自枚举类)
     * @param message   自定义消息
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }

    /**
     * 条件成立抛异常
     *
     * @param condition 条件
     * @param code      自定义错误码
     * @param message   自定义消息
     */
    public static void throwIf(boolean condition, int code, String message) {
        throwIf(condition, new BusinessException(code, message));
    }
}
