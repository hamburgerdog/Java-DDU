package org.xjosiah.designmodel.simplefactory;

import org.xjosiah.designmodel.simplefactory.operation.Operation;

import java.lang.reflect.InvocationTargetException;

public class OperationFactory {
    public static <T extends Operation> T getOperation(Class<T> clz) {
        try {
            return clz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private OperationFactory() {}
}
