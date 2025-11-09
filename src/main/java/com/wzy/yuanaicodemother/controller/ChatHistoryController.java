package com.wzy.yuanaicodemother.controller;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.wzy.yuanaicodemother.annotation.AuthCheck;
import com.wzy.yuanaicodemother.common.BaseResponse;
import com.wzy.yuanaicodemother.common.ResultUtils;
import com.wzy.yuanaicodemother.constant.UserConstant;
import com.wzy.yuanaicodemother.exception.ErrorCode;
import com.wzy.yuanaicodemother.exception.ThrowUtils;
import com.wzy.yuanaicodemother.model.dto.chathistory.ChatHistoryQueryRequest;
import com.wzy.yuanaicodemother.model.entity.ChatHistory;
import com.wzy.yuanaicodemother.model.entity.User;
import com.wzy.yuanaicodemother.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.wzy.yuanaicodemother.service.ChatHistoryService;

import java.time.LocalDateTime;

/**
 * 对话历史 控制层。
 *
 * @author wzy
 */
@RestController
@RequestMapping("/chatHistory")
public class ChatHistoryController {

    @Resource
    private ChatHistoryService chatHistoryService;

    @Resource
    private UserService userService;

    /**
     * 分页查询某个应用的对话历史（游标查询）
     *
     * @param appId          应用id
     * @param pageSize       每页大小
     * @param lastCreateTime 上一次查询最后一条记录的创建时间
     * @param request        http请求
     * @return 对话历史分页结果
     */
    @GetMapping("/app/{appId}")
    public BaseResponse<Page<ChatHistory>> listAppChatHistoryByPage(@PathVariable Long appId,
                                                                    @RequestParam(defaultValue = "10") int pageSize,
                                                                    @RequestParam(required = false) LocalDateTime lastCreateTime,
                                                                    HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        Page<ChatHistory> chatHistoryPage = chatHistoryService.listAppChatHistoryByPage(appId, pageSize, lastCreateTime, loginUser);
        return ResultUtils.success(chatHistoryPage);
    }

    /**
     * 管理员分页查询所有对话历史
     *
     * @param chatHistoryQueryRequest 查询请求
     * @return 对话历史分页
     */
    @PostMapping("/admin/list/page/vo")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<ChatHistory>> listAllChatHistoryByPageForAdmin(@RequestBody ChatHistoryQueryRequest chatHistoryQueryRequest) {
        ThrowUtils.throwIf(chatHistoryQueryRequest == null, ErrorCode.PARAMS_ERROR);
        long pageNum = chatHistoryQueryRequest.getPageNum();
        long pageSize = chatHistoryQueryRequest.getPageSize();
        // 查询数据
        QueryWrapper queryWrapper = chatHistoryService.getQueryWrapper(chatHistoryQueryRequest);
        Page<ChatHistory> result = chatHistoryService.page(Page.of(pageNum, pageSize), queryWrapper);
        return ResultUtils.success(result);
    }
}
