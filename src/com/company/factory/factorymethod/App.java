package com.company.factory.factorymethod;

/**
 * 静态工厂：People ple=People.getInstence;
 */
public class App {
    public static void main(String[] args) {
        Phone phone = new IphoneFactory().createPhone();
        phone.dosome();
    }
}
