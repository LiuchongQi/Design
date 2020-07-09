package com.company.templatemethod;

/**
 * 模板方法（钩子函数）
 */
public class App {
}
abstract class f{
    public void m(){
        op1();
        op2();
    }
    abstract void op1();
    abstract void op2();
}
class s extends f{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}