package com.设计模式;
/**
 * 代理模式
 * @author Seki
 *
 */

public class Proxy implements Sourceable{
	
	public class Source implements Sourceable {  
		  
	    @Override  
	    public void method() {  
	        System.out.println("the original method!");  
	    }  
	}  
	
	private Source source;
	//构造方法
	public Proxy(){
		super();
		this.source = new Source();
	}
	
	@Override  
    public void method() {  
        before();  
        source.method();  
        after();  
    }  
	
	private void after() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    }  
	
	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
	}
	
}
