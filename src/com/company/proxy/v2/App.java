package com.company.proxy.v2;

import java.util.Random;

/**
 * 装饰者实现代理组合
 */
public class App {
    public static void main(String[] args) {
        //Tank tank = new Tank();
        Car tank = new Car();
        ProxyTimeTank proxyTimeTank = new ProxyTimeTank(tank);
        ProxyLogTank proxyLogTank = new ProxyLogTank(proxyTimeTank);
        proxyLogTank.move();
    }
}

interface Movable{
    Movable move();
}

class Tank implements Movable {

    @Override
    public Movable move() {
        System.out.println("坦克行进中。。。。。。");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
class Car implements Movable {

    @Override
    public Movable move() {
        System.out.println("汽车行进中。。。。。。");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ProxyTimeTank implements Movable {
    Movable tank;

    public ProxyTimeTank(Movable tank) {
        this.tank = tank;
    }

    @Override
    public Movable move() {
        long start=System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.print("1:");
        System.out.println(end-start);
        return tank;
    }
}
class ProxyLogTank implements Movable {
    Movable tank;

    public ProxyLogTank(Movable tank) {
        this.tank = tank;
    }

    @Override
    public Movable move() {
        System.out.println("开始了");
        tank.move();
        System.out.println("结束了");
        return tank;
    }
}