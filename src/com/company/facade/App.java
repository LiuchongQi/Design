package com.company.facade;

/**
 * 门面模式：处理对外的复杂逻辑
 * 调停者：处理内部复杂逻辑
 */
public class App {
    public static void main(String[] args) {
        new Baogongtou().dosomme();
    }
}

class Baogongtou{
    public void dosomme(){
        new Wagong().dosome();
        new Mugong().dosome();
    }
}
class Wagong{
    public void dosome(){
        System.out.println("wagong");
    }
}
class Mugong{
    public void dosome(){
        System.out.println("mugong");
    }
}
