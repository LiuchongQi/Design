package com.company.single;

import static com.company.single.Single03.getInstance;

public class Single{

    public static void main(String[] args) {
        Single04.instence.doSomething();

    }
}

class Single01 {
    private Single01(){};
    private static final Single01 instence=new Single01();  //final防止被改变
    public static Single01 getInstence(){
        return instence;
    }
    public void doSomething(){
        System.out.println("hello");
    }
}
        /*为什么加volatile
        时间	线程A	线程B
        t1	    A1：分配对象的内存空间
        t2	    A3：设置instance指向内存空间
        t3	 	        B1：判断instance是否为空
        t4	 	        B2：由于instance不为null，线程B将访问instance引用的对象（而这个时候对象还没有初始化）
        t5	    A2：初始化对象
        t6	    A4：访问instance引用的对象*/
class Single02{
    private Single02(){};
    private static volatile Single02 instence;
    public static Single02 getInstence(){  //直接锁方法效率太低
        if(instence==null){
            synchronized (Single02.class){
                if(instence==null) {      //防止第一次判空后等锁时新建
                    instence = new Single02();
                }
            }

        }
        return instence;
    }
}
/*
        SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用，
        所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
        利用classloader同步
 */
class Single03{
    private Single03(){};
    private static class SingleHolder{
        private static final Single03 instence=new Single03();
    }
    public static Single03 getInstance(){
        return SingleHolder.instence;
    }
}

enum  Single04{
    instence;
    public void doSomething(){
        System.out.println("hello");
    }
}

