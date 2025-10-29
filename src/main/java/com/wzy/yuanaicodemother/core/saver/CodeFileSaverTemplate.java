package com.wzy.yuanaicodemother.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.wzy.yuanaicodemother.constant.AppConstant;
import com.wzy.yuanaicodemother.exception.BusinessException;
import com.wzy.yuanaicodemother.exception.ErrorCode;
import com.wzy.yuanaicodemother.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @param <T> 保存的文件类型
 *            抽象代码文件保存器 - 模板方法模式
 * @Author: [wzyWorker]
 * @Date: 2025/10/8 18:20
 */
public abstract class CodeFileSaverTemplate<T> {

    private static final String FILE_SAVE_ROOT_DIR = AppConstant.CODE_OUTPUT_ROOT_DIR;

    /**
     * 保存代码文件的标准流程
     *
     * @param result 代码结果对象
     * @param appId  应用 ID
     * @return 保存的文件目录对象
     */
    public final File saveCode(T result, Long appId) {
        // 1.校验输入
        validateInput(result);
        // 2.构建唯一目录
        String baseDirPath = buildUniqueDir(appId);
        // 3.保存文件（具体实现交给子类）
        saveFiles(result, baseDirPath);
        // 4.返回保存结果，文件目录对象
        return new File(baseDirPath);
    }

    /**
     * 保存单个文件
     *
     * @param dirPath  文件路径
     * @param fileName 文件名
     * @param content  内容
     */
    public final void writeToFile(String dirPath, String fileName, String content) {
        if (StrUtil.isNotBlank(content)) {
            String filePath = dirPath + File.separator + fileName;
            FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
        }
    }

    /**
     * 验证输入参数（可由子类覆盖）
     *
     * @param result 代码结果对象
     */
    protected void validateInput(T result) {
        if (result == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "代码结果对象不能为空");
        }
    }

    /**
     * 构建文件的唯一路径：tmp/code_output/bizType_雪花 ID
     *
     * @param appID 应用 ID
     * @return 路径
     */
    protected String buildUniqueDir(Long appID) {
        if (appID == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "应用 ID 不能为空");
        }
        // 调用子类的方法获取类型
        String codeType = getCodeType().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", codeType, appID);
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    /**
     * 保存文件
     *
     * @param result      代码结果对象
     * @param baseDirPath 保存文件基础目录
     */
    protected abstract void saveFiles(T result, String baseDirPath);

    /**
     * 获取代码生成类型
     *
     * @return 代码生成类型枚举
     */
    protected abstract CodeGenTypeEnum getCodeType();
}
