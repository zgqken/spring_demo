package com.ken.javase.design_pattern;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/8/11 0011
 */
public class CommandPattern {

    public static void main(String[] args) {
        //接收者可以做成多个
        Reciver reciver =new Reciver();
        Command command = new ConcreteCommand(reciver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}

interface Command{
    void execute();
}

class ConcreteCommand implements Command{

    private Reciver reciver;

    public ConcreteCommand(Reciver reciver) {
        this.reciver = reciver;
    }

    @Override
    public void execute() {
        reciver.action();
    }
}

class Reciver{
    public void action(){
        System.out.println("do some actions");
    }

}

class Invoker{

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}
