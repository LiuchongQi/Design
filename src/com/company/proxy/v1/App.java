package com.company.proxy.v1;

import java.util.Random;

/**
 * 聚合
 */
public class App {
    public static void main(String[] args) {
        new ProxyTimeTank(new Tank()).move();
    }
}
interface Movable{
    void move();
}
class Tank implements Movable{

    @Override
    public void move() {
        System.out.println("坦克行进中。。。。。。");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ProxyTimeTank implements Movable{
    Tank tank;

    public ProxyTimeTank(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start=System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}