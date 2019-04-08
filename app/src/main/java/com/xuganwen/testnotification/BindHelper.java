package com.xuganwen.testnotification;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

/**
 * 文件描述：
 * 作者：徐干稳
 * 创建时间：2019/4/4
 * 更改时间：2019/4/4
 * 版本号：1.0
 */
public class BindHelper {

    public static void bindView(Activity activity) {
        try {
            Class clazz = activity.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(BindView.class)) {
                    BindView bindView = field.getAnnotation(BindView.class);
                    field.setAccessible(true);
                    field.set(activity, activity.findViewById(bindView.value()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
