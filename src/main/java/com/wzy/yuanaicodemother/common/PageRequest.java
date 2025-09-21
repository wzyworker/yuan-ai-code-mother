package com.wzy.yuanaicodemother.common;

import lombok.Data;

/**
 * @author wzy
 * @date 2025年09月06日 23:00
 * 通用的分页请求类
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 页面条数
     */
    private int pageSize = 20;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序(默认升序)
     */
    private String sortOrder = "descend";
}
