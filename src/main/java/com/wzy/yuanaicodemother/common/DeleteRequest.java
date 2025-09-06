package com.wzy.yuanaicodemother.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzy
 * @date 2025年09月06日 23:00
 * 通用的删除请求类
 */
@Data
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = -4657822850815782011L;

    private Long id;
}
