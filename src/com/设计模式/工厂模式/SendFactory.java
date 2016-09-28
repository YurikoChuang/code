package com.设计模式.工厂模式;



/**
 * 工厂方法模式
 * @author Kaname
 *
 */
public class SendFactory {
	
	public Sender produce(String type) {  
		if ("mail".equals(type)) {  
	        return new MailSender();  
	    } else if ("sms".equals(type)) {  
	        return new SmsSender();  
	    } else {  
	        System.out.println("请输入正确的类型!");  
	        return null;  
	    }  
	} 
	
	public static void main(String[] args) {
		   SendFactory factory = new SendFactory();  
	       Sender sender = factory.produce("sms");  
	       sender.Send();  
	}
}
