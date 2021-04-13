package org.xjosiah.designmodel.strategy.Cash;

public class CashRebate extends CashSuper {
    private double rebate;

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * rebate;
    }
}
