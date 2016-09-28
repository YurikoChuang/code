package com.设计模式;
/**
 * 单例模式
 * 基于多线程
 *  JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
 *  这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
 *  并且会保证把赋值给instance的内存初始化完毕
 *  此外该方法也只会在第一次调用的时候使用互斥机制
 * @author Seki
 *
 */
public class Singleton {
	 private static Singleton uniqueInstance = null;
	 
     private Singleton() {
    	 
     }
     
     private static class SingletonContainer{        
         private static Singleton instance = new Singleton();        
     }        
     
     public static Singleton getInstance(){        
         return SingletonContainer.instance;        
     }        
}
