package com.设计模式.抽象工厂;



public class MailSender implements Sender{
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}
