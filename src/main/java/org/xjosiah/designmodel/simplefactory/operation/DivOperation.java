package org.xjosiah.designmodel.simplefactory.operation;

public class DivOperation extends Operation {
    @Override
    public double compute(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return a / b;
    }
}
