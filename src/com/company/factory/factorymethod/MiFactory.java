package com.company.factory.factorymethod;

public class MiFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Mi();
    }
}
