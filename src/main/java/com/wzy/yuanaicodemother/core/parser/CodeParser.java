package com.wzy.yuanaicodemother.core.parser;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/8 17:55
 */
public interface CodeParser<T> {

    /**
     * 解析代码内容
     *
     * @param codeContent 原始代码内容
     * @return 解析后的结果对象
     */
    T parseCode(String codeContent);
}
