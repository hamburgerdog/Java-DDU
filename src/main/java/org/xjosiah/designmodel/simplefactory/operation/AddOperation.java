package org.xjosiah.designmodel.simplefactory.operation;

public class AddOperation extends Operation {
    @Override
    public double compute(double a, double b) {
        return a + b;
    }
}
