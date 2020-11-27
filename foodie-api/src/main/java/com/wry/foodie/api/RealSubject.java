package com.wry.foodie.api;

/**
 * 实际对象
 */
public class RealSubject implements Subject {

    /**
     * 你好
     *
     * @param name
     * @return
     */
    @Override
    public void SayHello(String name) {
        System.out.println("hello " + name);

        SayHi(name);
    }
    public void SayHi(String name) {
        System.out.println("hi " + name);
    }

    /**
     * 再见
     *
     * @return
     */
    @Override
    public void SayGoodBye() {
        System.out.println("good bye ");
    }
}
