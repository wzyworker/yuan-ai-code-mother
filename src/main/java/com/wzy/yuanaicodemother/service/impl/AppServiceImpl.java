package com.wzy.yuanaicodemother.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.wzy.yuanaicodemother.model.entity.App;
import com.wzy.yuanaicodemother.mapper.AppMapper;
import com.wzy.yuanaicodemother.service.AppService;
import org.springframework.stereotype.Service;

/**
 * 应用 服务层实现。
 *
 * @author wzy
 */
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App>  implements AppService{

}
