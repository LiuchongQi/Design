package com.company.factory.abstractfactory;

public class XiaomiFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new Xiaomi();
    }

    @Override
    public Computer createComputer() {
        return new XiaomiCom();
    }
}
