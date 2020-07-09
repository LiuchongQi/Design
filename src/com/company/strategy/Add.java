package com.company.strategy;

public class Add implements Strategy<Integer> {
    @Override
    public Integer calc(Integer t1, Integer t2) {
        return t1+t2;
    }
}
