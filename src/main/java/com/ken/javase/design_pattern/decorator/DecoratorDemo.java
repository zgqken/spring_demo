package com.ken.javase.design_pattern.decorator;

/**
 * 类名称：
 * 类描述：装饰器模式
 * 创建人：zgquan
 * 创建日期：2017/7/2
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(concreteComponent);
        decoratorA.operation();
    }

}


interface Component{
    void operation();
}

/**
 * 具体的实现类
 */
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println(" concrete component");
    }
}

/**
 * 装饰类
 */
class Decorator implements Component{

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

/**
 * 具体装饰类
 */
class ConcreteDecoratorA extends Decorator {


    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        //调用父类方法
        super.operation();
        addOperation();
    }

    public void addOperation(){
        System.out.println(" add operation");
    }
}