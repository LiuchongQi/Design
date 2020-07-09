package com.company.composite;


import java.util.ArrayList;

/**
 * 组合模式
 * 树状结构专用模式
 */
public class App {
    public static void main(String[] args) {
        BranchNode root=new BranchNode("root");
        BranchNode Branch1=new BranchNode("Branch1");
        BranchNode Branch2=new BranchNode("Branch2");
        LeafNode leaf11=new LeafNode("leaf11");
        LeafNode leaf12=new LeafNode("leaf12");
        LeafNode leaf21=new LeafNode("leaf21");
        LeafNode leaf22=new LeafNode("leaf22");
        root.add(Branch1);
        root.add(Branch2);
        Branch1.add(leaf11);
        Branch1.add(leaf12);
        Branch2.add(leaf21);
        Branch2.add(leaf22);
        tree(root,0);
    }
    public static void tree(Node node,int depth){
        for(int i=0;i<depth;i++){
            System.out.print("==");
        }
        node.dosome();
        if(node instanceof BranchNode){
            for (Node n:((BranchNode)node).getArr()) {
                tree(n,depth+1);
            }

        }

    }
}
interface Node{
    void dosome();
}
class BranchNode implements Node{
    private String name;
    ArrayList<Node> arr=new ArrayList<Node>();
    public BranchNode(String name){
        this.name=name;
    }
    public void add(Node node){
        arr.add(node);
    }
    public ArrayList<Node> getArr(){
        return arr;
    }
    @Override
    public void dosome() {
        System.out.println(name);
    }
}
class LeafNode implements Node{
    private String name;
    public LeafNode(String name){
        this.name=name;
    }
    @Override
    public void dosome() {
        System.out.println(name);
    }
}
