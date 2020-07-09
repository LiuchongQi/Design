package com.company.prototype;

/**
 * 浅克隆（直接复制内存）
 */
public class App1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person1.toString());

        System.out.println(person1.loc==person2.loc);
        person1.loc.street="bj";
        System.out.println(person2.loc);
    }
}
class Person implements Cloneable{
    String name="tom";
    Location loc=new Location("sh");
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", loc=" + loc +
                '}';
    }
}
class Location{
    String street;

    public Location(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                '}';
    }
}