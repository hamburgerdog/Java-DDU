package org.xjosiah.designmodel.strategy.Cash;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
