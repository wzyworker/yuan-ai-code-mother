package com.wzy.yuanaicodemother.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wzy
 * @date 2025年09月21日 21:23
 * 权限校验注解
 * 两个注解分别表示，方法注解，运行时注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 必须要有的角色
     *
     * @return
     */
    String mustRole() default "";

}
