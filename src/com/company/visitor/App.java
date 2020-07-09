package com.company.visitor;

/**
 * 主要将数据结构与数据操作分离。
 */
public class App {
    public static void main(String[] args) {
        new Computer().useCom(new Usb());
    }
}
interface HardWareInterface{
    public void visitor(Cpu cpu);
    public void visitor(HardDisk hardDisk);
}
interface ComputerPart{
    void link(HardWareInterface hardWareInterface);
}
class Cpu implements ComputerPart{

    @Override
    public void link(HardWareInterface hardWareInterface) {
        hardWareInterface.visitor(this);
        System.out.println("cpu可以工作");
    }
}
class HardDisk implements ComputerPart{

    @Override
    public void link(HardWareInterface hardWareInterface) {
        hardWareInterface.visitor(this);
        System.out.println("硬盘开始工作");
    }
}
class Usb implements HardWareInterface{

    @Override
    public void visitor(Cpu cpu) {
        System.out.println("连接cpu");
    }

    @Override
    public void visitor(HardDisk hardDisk) {
        System.out.println("连接硬盘");
    }
}
class Computer{
    public void useCom(HardWareInterface hardWareInterface){
        new Cpu().link(hardWareInterface);
        new HardDisk().link(hardWareInterface);
    }
}