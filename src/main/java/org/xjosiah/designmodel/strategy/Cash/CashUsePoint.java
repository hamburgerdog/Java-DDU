package org.xjosiah.designmodel.strategy.Cash;

public class CashUsePoint extends CashSuper {
    private double point;

    public CashUsePoint(double point) {
        this.point = point;
    }

    @Override
    public double acceptCash(double money) {
        return money - point / 100;
    }
}
