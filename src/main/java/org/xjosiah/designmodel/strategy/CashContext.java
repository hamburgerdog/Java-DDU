package org.xjosiah.designmodel.strategy;

import org.xjosiah.designmodel.strategy.Cash.*;

public class CashContext {
    private CashSuper cash;

    public CashContext(String Strategy) {
        switch (Strategy) {
            case "a":
                this.cash = new CashRebate(0.8);
                break;
            case "b":
                this.cash = new CashReturn(30);
                break;
            case "c":
                this.cash = new CashUsePoint(100);
                break;
            default:
                this.cash = new CashNormal();
        }
    }

    public double getCash(double money) {
        return cash.acceptCash(money);
    }
}
