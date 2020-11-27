package com.wry.foodie.api;

/**
 * 需要动态代理的接口
 */
public interface Subject {
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public void SayHello(String name);

    /**
     * 再见
     *
     * @return
     */
    public void SayGoodBye();
}