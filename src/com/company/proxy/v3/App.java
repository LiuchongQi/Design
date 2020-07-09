package com.company.proxy.v3;

import java.util.Random;

/**
 * 静态代理
 */
public class App {
    public static void main(String[] args) {
        new ProxyTimeTank(new ProxyLogTank(new Tank())).move();

    }
}

interface Movable{
    void move();
}

class Tank implements Movable {

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

class Car implements Movable {

    @Override
    public void move() {
        System.out.println("汽车行进中。。。。。。");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProxyTimeTank implements Movable {
    Movable tank;

    public ProxyTimeTank(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.print("1:");
        System.out.println(end - start);
    }
}

class ProxyLogTank implements Movable {
    Movable tank;

    public ProxyLogTank(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("开始了");
        tank.move();
        System.out.println("结束了");
    }
}