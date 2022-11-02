package org.example.util;

import org.example.test.service.WordProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成代理对象工具类
 */
public class DynamicProxyUtil {

    public static <T> T getProxy(Class<T> clazz, T obj) {
        InvocationHandler wordProxyHandler = new WordProxyHandler(obj);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, wordProxyHandler);
    }
}