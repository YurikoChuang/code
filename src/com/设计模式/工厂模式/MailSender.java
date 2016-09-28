package com.设计模式.工厂模式;



public class MailSender implements Sender{
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}
