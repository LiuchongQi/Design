package com.company.factory.abstractfactory;

public class App {
    public static void main(String[] args) {
        Factory xiaomiFactory = new XiaomiFactory();
        xiaomiFactory.createPhone().call();
        xiaomiFactory.createComputer().play();

        Factory huaweiFactory = new HuaweiFactory();
        huaweiFactory.createPhone().call();
        huaweiFactory.createComputer().play();
    }
}
