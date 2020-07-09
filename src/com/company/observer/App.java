package com.company.observer;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        MySubject mySubject = new MySubject(new Event(1));
        mySubject.addObserver(new Observer1());
        mySubject.dosome();
    }
}
class subject{
    private ArrayList<Observer> arr=new ArrayList<Observer>();
    private Event e;
    public subject(Event e){
        this.e=e;
    }
    public void addObserver(Observer observer){
        arr.add(observer);
    }
    public void removeObserver(Observer observer){
        arr.remove(observer);
    }
    public void notifyObserver(){
        for(Observer observer:arr){
            observer.actionOnEvent(e);
        }
    }
}
class MySubject extends subject{

    public MySubject(Event e) {
        super(e);
    }

    public void dosome(){
        super.notifyObserver();
        System.out.println("被观察者行动");
    }
}
class Event{
    private int loc;
    public Event(int loc){
        this.loc=loc;
    }
    public int getLoc(){
        return loc;
    }
}
interface Observer{
    void actionOnEvent(Event e);
}
class Observer1 implements Observer{

    @Override
    public void actionOnEvent(Event e) {
        System.out.println("观察者行动");
    }
}