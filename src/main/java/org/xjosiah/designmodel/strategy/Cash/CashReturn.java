package org.xjosiah.designmodel.strategy.Cash;

public class CashReturn extends CashSuper {
    private double returnMoney;

    public CashReturn(double returnMoney) {
        this.returnMoney = returnMoney;
    }

    @Override
    public double acceptCash(double money) {
        return money - returnMoney;
    }
}
