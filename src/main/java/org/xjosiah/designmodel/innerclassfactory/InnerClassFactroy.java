package org.xjosiah.designmodel.innerclassfactory;

/**
 * 通过静态内部类实现的简单工厂模式，在初始化后就保持对象不变，
 * 关键字：「线程安全」、「懒加载」
 *
 * @author xjosiah
 * @since 2021/4/15
 */
public class InnerClassFactroy {
    //  静态以懒加载并保证线程安全
    private static class InnerClass {
        private String name;

        public InnerClass(String name) {
            this.name = name;
        }
    }

    //  innerClass可通过方法初始化，或者直接实现初始化
    private static InnerClass innerClass;

    private InnerClassFactroy() {
    }

    public static InnerClass getInnerClass(String innerClassName) {
        if (innerClass == null) new InnerClass(innerClassName);    //  第一次初始化后就一直不变
        return innerClass;
    }

}
