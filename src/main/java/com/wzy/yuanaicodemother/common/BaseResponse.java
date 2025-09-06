package com.wzy.yuanaicodemother.common;

import com.wzy.yuanaicodemother.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月06日 22:41
 * 全局响应封装类，以后所有的接口返回给前端，都需要用此类进行包装
 */
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 2025839838563705762L;

    private int code;

    private String message;

    private T data;

    public BaseResponse(int code, String message, T data) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, "", data);
    }

    /**
     * 异常的响应，返回数据为空，错误码和消息使用枚举
     *
     * @param errorCode 错误码
     */
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null);
    }
}
