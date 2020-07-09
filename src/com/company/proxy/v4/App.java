package com.company.proxy.v4;

import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;
import java.util.Random;

/**
 * 动态代理
 * java.lang.instrument  在已有的类上附加（修改）字节码来实现增强的逻辑
 */
public class App {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Movable movable= (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), Tank.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始了");
                        Object invoke = method.invoke(tank, args);
                        System.out.println("结束了");
                        return proxy;
                    }
                });
        //调用代理类的move
        movable.move();
        writeClassToDisk("D:/$Proxy4.class");
    }
    public static void writeClassToDisk(String path){

        byte[] classFile = ProxyGenerator.generateProxyClass("$proxy4", new Class[]{Movable.class});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
