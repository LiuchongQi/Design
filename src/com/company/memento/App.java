package com.company.memento;

import java.io.*;
import java.util.UUID;

/**
 * 备忘录模式
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        person person = new person();
        person.name="tom";
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        oo.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        person person1 = (person) objectInputStream.readObject();
        System.out.println(person1.toString());
    }
}
class person implements Serializable {
    String name;
    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }
}
