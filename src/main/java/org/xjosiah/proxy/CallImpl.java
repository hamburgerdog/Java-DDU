package org.xjosiah.proxy;


import cn.hutool.core.lang.Console;

public class CallImpl implements Call {
    @Override
    public void call() {
        Console.log("打电话中");
    }
}
