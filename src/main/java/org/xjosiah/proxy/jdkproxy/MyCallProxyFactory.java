package org.xjosiah.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * JDK代理的核心是利用Invocation接口实现的方法来执行代理
 *
 * @author xjosiah
 * @since 2021/4/13
 */
public class MyCallProxyFactory {
    private MyCallProxyFactory() {
    }

    /**
     * 创建代理
     *
     * @param object 被代理对象
     * @return 代理对象
     */
    public static Object createProxy(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new CallInvocationHandler(object));
    }
}
