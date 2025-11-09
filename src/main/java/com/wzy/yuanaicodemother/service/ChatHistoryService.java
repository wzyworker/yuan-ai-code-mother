package com.wzy.yuanaicodemother.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.wzy.yuanaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.wzy.yuanaicodemother.model.entity.ChatHistory;
import com.wzy.yuanaicodemother.model.entity.User;

import java.time.LocalDateTime;

/**
 * 对话历史 服务层。
 *
 * @author wzy
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加消息记录
     *
     * @param appId       应用id
     * @param message     消息内容
     * @param messageType 消息类型
     * @param userId      用户id
     * @return 是否添加成功
     */
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用id删除消息记录
     *
     * @param appId 应用id
     * @return 是否删除成功
     */
    boolean deleteByAppId(Long appId);


    /**
     * 分页查询某 APP 的对话记录
     *
     * @param appId          应用id
     * @param pageSize       每页大小
     * @param lastCreateTime 上一次查询最后一条记录时间
     * @param loginUser      登录用户
     * @return 对话记录
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize, LocalDateTime lastCreateTime, User loginUser);

    /**
     * 构造查询条件
     *
     * @param chatHistoryQueryRequest 查询请求
     * @return 查询条件
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);
}
