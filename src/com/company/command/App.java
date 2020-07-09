package com.company.command;

/**
 * 命令模式
 */
public class App {
    public static void main(String[] args) {
        Content content = new Content();
        CopyComm copyComm = new CopyComm(content);
        copyComm.doit();
        copyComm.undo();
        InsertComm world = new InsertComm(content, "world");
        world.doit();
        world.undo();

        System.out.println(content.msg);
    }
}
interface Command{
    void doit();
    void undo();
}
class Content{
    String msg="hello";
}
class CopyComm implements Command{
    private Content content;

    public CopyComm(Content content) {
        this.content = content;
    }

    @Override
    public void doit() {
        content.msg=content.msg+content.msg;
    }

    @Override
    public void undo() {
        content.msg=content.msg.substring(0,content.msg.length()/2);
    }
}
class InsertComm implements Command{
    private Content content;
    private String word;
    public InsertComm(Content content,String word) {
        this.content = content;
        this.word = word;
    }

    @Override
    public void doit() {
        this.content.msg+=word;
    }

    @Override
    public void undo() {
        this.content.msg=this.content.msg.substring(0,this.content.msg.length()-word.length());
    }
}