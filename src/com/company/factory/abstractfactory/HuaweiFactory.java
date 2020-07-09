package com.company.factory.abstractfactory;

public class HuaweiFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new Huawei();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiCom();
    }
}
