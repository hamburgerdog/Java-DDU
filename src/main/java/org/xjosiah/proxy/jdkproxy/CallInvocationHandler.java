package org.xjosiah.proxy.jdkproxy;

import cn.hutool.core.lang.Console;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理方法实现的接口
 *
 * @author xjosiah
 * @since 2021/4/13
 */
public class CallInvocationHandler implements InvocationHandler {
    private Object object;

    public CallInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * 实现代理过程的方法
     *
     * @param proxy  实现代理的对象
     * @param method 代理的方法
     * @param args   代理方法的参数
     * @return 代理方法执行的结果
     * @throws Throwable 可抛出异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Console.log("开始监听打电话");
        Object invoke = method.invoke(object, args);
        Console.log("通话结束，停止监听");
        return invoke;
    }
}
