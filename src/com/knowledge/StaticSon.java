package com.knowledge;

public class StaticSon extends FatherBlock {
    boolean bool;
    final short finalShort = 18;
    byte b;
    private int priInt;

//    构造方法
    public StaticSon(){
        System.out.println("子类--" + StaticSon.class.getName() + "的无参构造方法");
    }

    public StaticSon(boolean b){
        this.bool = b;
        System.out.println("子类--" + StaticSon.class.getCanonicalName() + "的有参构造方法");
    }

//    构造块
    {
        b = 2;
        System.out.println("子类--" + StaticSon.class.getSimpleName()
                + "中的构造代码块, byte:b = " + b + ",finalShort = " + finalShort);
    }

    {
        priInt = 3;
        System.out.println("子类--" + StaticSon.class.getSimpleName() + "中的构造代码块, priInt = " + priInt);
    }

//    静态代码块
    static {
//        b = 4;
        System.out.println("子类--" + StaticSon.class.getSimpleName()
                + "中的静态代码块, 并且不能初始化类成员变量");
    }

    static {
//        System.out.println(finalShort);
        System.out.println("子类--" + StaticSon.class.getSimpleName()
                + "中的静态代码块, 并且不能引用类成员变量");
    }

    public boolean getBool(){
        {
            System.out.println("子类--" + StaticSon.class.getSimpleName()
                    + "方法中的类普通代码块");
        }
        return this.bool;
    }

    @Override
    public String toString(){
        return "子类--" + StaticSon.class.getCanonicalName()+"的toString方法, 普通代码块";
    }

    public static void main(String[] args) throws InterruptedException {
        new StaticSon();
        System.err.println("------------------------------------");
        Thread.sleep(1000);
        StaticSon son = new StaticSon();
        System.err.println("总结：\t静态代码块只执行一次");
        System.err.println("------------------------------------");
        Thread.sleep(1000);
        new StaticSon(false).getBool();
        son.getBool();
        System.err.println("总结：\t执行顺序优先级：静态代码块>构造代码块>构造方法>普通代码块");

        Thread.sleep(1000);
        System.err.println("\n\n------------------------------------\n\n");
        System.out.println(new StaticSon());
        Thread.sleep(1000);
        System.err.println("------------------------------------");
        StaticSon secondSon = new StaticSon();
        System.out.println(secondSon);
        System.err.println("结论：\t多继承中初始化块、静态初始化块、构造器的执行顺序优先级为：" +
                "父类静态块>子类静态块>父类构造代码块>父类构造器>子类构造代码块>子类构造器");
    }

}

class FatherBlock extends GrandPaBlock {
    {
        System.out.println("父类--" + FatherBlock.class.getName() + "中的构造代码块");
    }

    FatherBlock() {
        System.out.println("父类--" + FatherBlock.class.getName() + "中的无参构造方法");
    }

    static {
        System.out.println("父类--" + FatherBlock.class.getName() + "中的静态代码块");
    }

    @Override
    public String toString(){
        return "父类--" + FatherBlock.class.getCanonicalName()+"的toString方法, 普通代码块";
    }
}

class GrandPaBlock {
    {
        System.out.println("爷类--" + GrandPaBlock.class.getName() + "中的构造代码块");
    }

    GrandPaBlock() {
        System.out.println("爷类--" + GrandPaBlock.class.getName() + "中的无参构造方法");
    }

    static {
        System.out.println("父类--" + GrandPaBlock.class.getName() + "中的静态代码块");
    }

    @Override
    public String toString(){
        return "爷类--" + GrandPaBlock.class.getCanonicalName()+"的toString方法, 普通代码块";
    }
}