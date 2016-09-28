package com.设计模式.抽象工厂;

public class SendMailFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}
	
}
