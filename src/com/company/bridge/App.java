package com.company.bridge;

/**
 * 桥接模式
 */
public class App {
    public static void main(String[] args) {
        BigPen bigPen = new BigPen();
        bigPen.setColor(new Red());
        bigPen.draw("兔兔");
    }
}
abstract class Pen{
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(String name);
}
interface Color{
    void paint(String pen,String name);
}
class Red implements Color{

    @Override
    public void paint(String pen,String name) {
        System.out.println(pen+"用红色画"+name);
    }
}
class BigPen extends Pen{

    @Override
    public void draw(String name) {
        this.color.paint("大号笔",name);
    }
}
