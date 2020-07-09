package com.company.factory.simplefactory;

public class app {
    public static void main(String[] args) {
        phonefactory phonefactory = new phonefactory();
        phone phone = phonefactory.makeIphone();
        phone.dosome();
    }
}
