package com.ken.javase.design_pattern.chain_of_responsibility;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/8/4 0004
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handlern = new ConcreteHandlerN();

        //链起来
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handlern);

        //假设这个请求是ConcreteHandler2的责任
        handler1.handlerRequest("ConcreteHandler2");
    }
}


abstract class Handler{

    public Handler successor;

    public abstract void handlerRequest(String condition);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

class ConcreteHandler1  extends Handler{


    @Override
    public void handlerRequest(String condition) {
        // 如果是自己的责任，就自己处理，负责传给下家处理
        if (condition.equals("ConcreteHandler1")) {
            System.out.println("ConcreteHandler1 handled ");
            return;
        } else {
            System.out.println("ConcreteHandler1 passed ");
            getSuccessor().handlerRequest(condition);
        }
    }
}

class ConcreteHandler2 extends Handler {


    @Override
    public void handlerRequest(String condition) {
        // 如果是自己的责任，就自己处理，负责传给下家处理
        if (condition.equals("ConcreteHandler2")) {
            System.out.println("ConcreteHandler1 handled ");
            return;
        } else {
            System.out.println("ConcreteHandler2 passed ");
            getSuccessor().handlerRequest(condition);
        }
    }
}

class ConcreteHandlerN extends Handler {

    /**
     * 这里假设n是链的最后一个节点必须处理掉
     * 在实际情况下，可能出现环，或者是树形，
     * 这里并不一定是最后一个节点。
     */
    @Override
    public void handlerRequest(String condition) {

        System.out.println("ConcreteHandlerN handled");

    }

}
