package com.wzy.yuanaicodemother.exception;

import lombok.Getter;

/**
 * @author wzy
 * @date 2025年09月06日 22:33
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    // 手动定义错误码和自定义消息
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    // 指定公共错误码（枚举项中的）和原始报错信息
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    // 指定公共错误码（枚举项中的）和自定义消息
    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

}
