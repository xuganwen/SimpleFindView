package com.xuganwen.testnotification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件描述：
 * 作者：徐干稳
 * 创建时间：2019/4/4
 * 更改时间：2019/4/4
 * 版本号：1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface BindView {

    int value();

}
