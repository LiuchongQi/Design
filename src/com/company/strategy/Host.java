package com.company.strategy;

public class Host {
    /**
     * 作用：使客户端与策略解耦
     */
    private Strategy strategy;
    public Host(Strategy strategy){
        this.strategy=strategy;
    }
    public int cal(int t1,int t2){
        return (int) strategy.calc(t1,t2);
    }
}
