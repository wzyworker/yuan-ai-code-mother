package com.wzy.yuanaicodemother.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.wzy.yuanaicodemother.ai.model.HtmlCodeResult;
import com.wzy.yuanaicodemother.ai.model.MultiFileCodeResult;
import com.wzy.yuanaicodemother.model.enums.CodeGenTypeEnum;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @Author: [wzyWorker]
 * @Date: 2025/10/5 21:46
 * 文件保存器
 */
@Deprecated
public class CodeFileSaver {

    /**
     * 文件保存根目录
     */
    private static final String FILE_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/tmp/code_output";

    /**
     * 保存网页html代码
     *
     * @param htmlCodeResult html 生成结果
     * @return 文件路径
     */
    public static File saveHtmlCodeResult(HtmlCodeResult htmlCodeResult) {
        String baseDir = buildUniqueDir(CodeGenTypeEnum.HTML.getValue());
        writeToFile(baseDir, "index.html", htmlCodeResult.getHtmlCode());
        return new File(baseDir);
    }

    /**
     * 保存多文件代码
     *
     * @param multiFileCodeResult 多文件生成结果
     * @return 文件路径
     */
    public static File saveMultiFileCodeResult(MultiFileCodeResult multiFileCodeResult) {
        String baseDir = buildUniqueDir(CodeGenTypeEnum.MULTI_FILE.getValue());
        writeToFile(baseDir, "index.html", multiFileCodeResult.getHtmlCode());
        writeToFile(baseDir, "style.css", multiFileCodeResult.getCssCode());
        writeToFile(baseDir, "script.js", multiFileCodeResult.getJsCode());
        return new File(baseDir);
    }

    /**
     * 构建文件的唯一路径：tmp/code_output/bizType_雪花 ID
     *
     * @param bizType 代码生成器类型
     * @return 路径
     */
    private static String buildUniqueDir(String bizType) {
        String uniqueDirName = StrUtil.format("{}_{}", bizType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    /**
     * 保存单个文件
     *
     * @param dirPath  文件路径
     * @param fileName 文件名
     * @param content  内容
     */
    private static void writeToFile(String dirPath, String fileName, String content) {
        String filePath = dirPath + File.separator + fileName;
        FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
    }
}
