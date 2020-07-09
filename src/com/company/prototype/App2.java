package com.company.prototype;

/**
 * 深克隆
 * String s="1"不需要深克隆
 * new String("1")需要
 */
public class App2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person_ p1 = new Person_();
        Person_ p2 = (Person_) p1.clone();
        System.out.println(p1.toString());

        System.out.println(p1.loc==p2.loc);
        p1.loc.street="bj";

        System.out.println(p1.loc);
        System.out.println(p2.loc);
    }
}
class Person_ implements Cloneable{
    String name="tom";
    Location_ loc=new Location_("sh");
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person_ clone = (Person_)super.clone();
        clone.loc=(Location_) loc.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", loc=" + loc +
                '}';
    }
}
class Location_ implements Cloneable{
    String street;

    public Location_(String street) {
        this.street = street;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                '}';
    }
}