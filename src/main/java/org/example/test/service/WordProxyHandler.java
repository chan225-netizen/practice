package org.example.test.service;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 代理类
 */
public class WordProxyHandler implements InvocationHandler {
    private Object word;

    public WordProxyHandler(Object word) {
        this.word = word;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理哦！");
        before();
        Object result = method.invoke(word, args);
        after(args, result);
        return result;
    }

    private void before() {
        // TODO

    }

    private void after(Object[] args, Object result) {
        try {
            String content = args[0].toString();
            List<String> resultList = (List<String>) result;
            //MyLogUtil.printResult(content, resultList);
            System.out.println("模拟打印数据的操作");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
