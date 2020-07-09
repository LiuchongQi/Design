package com.company.iterator;


public class App {
    public static void main(String[] args) {
//        ArrayList_<String> stringArrayList_ = new ArrayList_<>();
//        for (int i = 0; i < 10; i++) {
//            stringArrayList_.add(new String("p"+i));
//        }
//        System.out.println(stringArrayList_.size());
//        iterator_ iterater = stringArrayList_.getIterater();
//        while(iterater.hasNext()){
//            System.out.println(iterater.next());
//        }

        LinkedList_<String> stringLinkedList_ = new LinkedList_<>();
        for (int i = 0; i < 10; i++) {
            stringLinkedList_.add(new String("p"+i));
        }
        System.out.println(stringLinkedList_.size());
        iterator_ iterater = stringLinkedList_.getIterater();
        while(iterater.hasNext()){
            System.out.println(iterater.next());
        }
    }
}
interface Collection_<E>{
    void add(E e);
    int size();
    iterator_ getIterater();
}
interface iterator_<E>{
    boolean hasNext();
    E next();
}
class LinkedList_<E> implements Collection_<E>{
    private Node head=null;
    private Node tail=null;
    private int size=0;
    private class Node<E>{
        E e;
        Node<E> next;
        public Node(E e){
            this.e=e;
        }
    }
    @Override
    public void add(E e) {
        if (head==null){
            head=new Node(e);
            tail=head;
            size++;
        }else{
            tail.next=new Node(e);
            tail=tail.next;
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public iterator_ getIterater() {
        return new LinkedIteraror();
    }
    private class LinkedIteraror<E> implements iterator_<E>{
        private int currentIndex=0;
        private Node currentNode=head;
        @Override
        public boolean hasNext() {
            if (currentIndex==size)return false;
            else return true;
        }

        @Override
        public E next() {
            E e= (E) currentNode.e;
            currentNode=currentNode.next;
            currentIndex++;
            return e;
        }
    }
}
class ArrayList_<E> implements Collection_<E>{
    private E[] obj= (E[]) new Object[10];
    private int size=0;


    @Override
    public void add(E e) {
        if(size==obj.length){
            E[] newObj= (E[]) new Object[size*2];
            System.arraycopy(obj,0,newObj,0,size);
            obj=newObj;
        }
        obj[size]=e;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public iterator_ getIterater() {
        return new ArrayIterator();
    }
    private class ArrayIterator<E> implements iterator_<E>{
        private int currentIndex=0;
        @Override
        public boolean hasNext() {
            if (currentIndex==size)return false;
            else return true;
        }

        @Override
        public E next() {
            E e=(E) obj[currentIndex];
            currentIndex+=1;
            return e;
        }
    }
}
