package com.company.builder;

/**
 * 构造器模式  也可称作静态工厂
 */
public class App {
    public static void main(String[] args) {
        People tom = new People.Builder(1, "tom").buildSex("man").buildWeight(120).buildHeight(75).build();
        System.out.println(tom.toString());
    }
}
class People{
    private int id;
    private String name;
    private String sex;
    private int height;
    private int weight;
    public People(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.sex=builder.sex;
        this.height=builder.height;
        this.weight=builder.weight;
    }
    public static class Builder{
        private int id;
        private String name;
        private String sex;
        private int height;
        private int weight;
        public Builder(int id,String name){
            this.id=id;
            this.name=name;
        }
        public Builder buildSex(String sex){
            this.sex=sex;
            return this;
        }
        public Builder buildHeight(int height){
            this.height=height;
            return this;
        }
        public Builder buildWeight(int weight){
            this.weight=weight;
            return this;
        }
        public People build(){
            return new People(this);
        }
    }


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}