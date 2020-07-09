package com.company.decorator;
//装饰者模式   java。io。*
public class App {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Salt salt = new Salt(coffee);
        System.out.println(salt.getDecoration());
        System.out.println(salt.coat());

    }
}
abstract class Drink{
    protected String description="no";
    public String getDescription(){
        return description;
    }
    public abstract int coat();
}

class Coffee extends Drink{
    public Coffee(){
        description="coffee";
    }
    @Override
    public int coat() {
        return 3;
    }
}
 abstract class Decorator extends Drink{
    abstract String getDecoration();
 }

 class Salt extends Decorator{
    Drink drink;
    public Salt(Drink drink){
        this.drink=drink;
    }
     @Override
     public int coat() {
         return 1+drink.coat();
     }

     @Override
     String getDecoration() {
         return drink.getDescription()+"+salt";
     }
 }