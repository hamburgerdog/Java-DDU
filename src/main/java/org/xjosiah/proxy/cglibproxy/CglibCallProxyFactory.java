package org.xjosiah.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * 使用Enhancer增强代理
 *
 * @author xjosiah
 * @since 2021/4/13
 */
public class CglibCallProxyFactory {
    private CglibCallProxyFactory() {
    }

    public static Object getProxy(Class<?> clz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clz.getClassLoader());
        enhancer.setSuperclass(clz);
        enhancer.setCallback(new CallMethodInterceptor());
        return enhancer.create();
    }
}
