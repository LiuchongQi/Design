package com.company.strategy;

public class App {
    public static void main(String[] args) {
        Host integerHost = new Host(new Add());
        Integer cal = integerHost.cal(1, 2);
        System.out.println(cal);
    }
}
