package org.xjosiah.proxy;

import org.xjosiah.proxy.cglibproxy.CglibCallProxyFactory;
import org.xjosiah.proxy.jdkproxy.MyCallProxyFactory;

public class MyProxyTestRun {
    public static void main(String[] args) {
        Call call = (Call) MyCallProxyFactory.createProxy(new CallImpl());
        call.call();

        Call proxy = (Call) CglibCallProxyFactory.getProxy(CallImpl.class);
        proxy.call();
    }
}
