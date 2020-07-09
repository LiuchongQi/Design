package com.company.chain;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好，hello world！！！");

        FilterChain1 filterChain = new FilterChain1();
        filterChain.add(new Filter1()).add(new Filter2()).add(new Filter3());
        filterChain.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
interface filter{
    boolean doFilter(Msg msg);
}
class Filter1 implements filter{

    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        String replace = msg1.replace("大家好", "nimenhao");
        msg.setMsg(replace);
        return true;
    }
}
class Filter2 implements filter{
    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        String replace = msg1.replace("hello", "你好");
        msg.setMsg(replace);
        return false;
    }
}
class Filter3 implements filter{
    @Override
    public boolean doFilter(Msg msg) {
        String msg1 = msg.getMsg();
        String replace = msg1.replace("！！！", "。。。。。。");
        msg.setMsg(replace);
        return true;
    }
}
class FilterChain1 implements filter{
    private ArrayList<filter> arr=new ArrayList<filter>();

    public FilterChain1 add(filter filter){
        arr.add(filter);
        return this;
    }
    @Override
    public boolean doFilter(Msg msg) {
        for (filter f:arr){
            boolean b = f.doFilter(msg);
            if (b==false){
                break;
            }
        }
        return true;
    }
}