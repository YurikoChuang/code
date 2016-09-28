package com.设计模式.抽象工厂;

public class AbstractFactory {
	public static void main(String[] args) {  
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
}
