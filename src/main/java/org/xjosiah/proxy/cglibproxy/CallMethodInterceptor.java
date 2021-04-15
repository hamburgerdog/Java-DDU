package org.xjosiah.proxy.cglibproxy;

import cn.hutool.core.lang.Console;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理
 *
 * @author xjosiah
 * @since 2021/4/13
 */
public class CallMethodInterceptor implements MethodInterceptor {
    /**
     * 代理实现
     *
     * @param o           代理的类
     * @param method      代理的方法
     * @param args     代理方法的参数
     * @param methodProxy 执行代理的方法
     * @return 执行代理的方法完成后返回的值
     * @throws Throwable 可抛出异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Console.log("开始监听电话");
        //  记得是invokeSuper(即使用代理类的方法)
        Object invoke = methodProxy.invokeSuper(o, args);
        Console.log("通话结束，停止监听");
        return invoke;
    }
}
