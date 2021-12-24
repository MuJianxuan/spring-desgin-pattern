package org.designpattern.spring.creationtype.singleton;

/**
 * 要考虑线程安全
 * @author Rao
 * @Date 2021/11/03
 **/
public class Singleton {

    /**
     * 饿汉式1
     */
    private static final Singleton SINGLETON = new Singleton();

    private static Singleton singleton;

    /**
     * 静态内部类
     */
    static class SingletonHolder{
        private static Singleton singleton = new Singleton();
    }


    /**
     * 饿汉式2
     */
    static {

        singleton = new Singleton();
    }

    private Singleton() {
    }

    /**
     * 很棒的模式 （推荐）
     *   同时兼具 懒加载和线程安全
     * @return
     */
    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }

    /**
     * 饿汉式
     * @return
     */
    public static Singleton getHungerInstance(){
        return SINGLETON;
    }


    /**
     * 会被反射 破解
     * @return
     */
    public synchronized static Singleton getInstance1(){

        if( singleton == null){
            return new Singleton();
        }
        return singleton;
    }

    /**
     * 会被反射 破解
     * @return
     */
    public static Singleton getInstance2(){
        if( singleton != null){
            return singleton;
        }

        // 双重校验
        synchronized ( Singleton.class){
            if( singleton != null){
                return singleton;
            }
            return new Singleton();
        }

    }

}
