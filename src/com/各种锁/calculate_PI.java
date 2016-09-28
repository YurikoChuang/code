package com.各种锁;

import java.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class calculate_PI {
    public static void main(String[] args) throws InterruptedException {
       long begin=System.currentTimeMillis();
       int threadSize=100;
       int N=1000000;
       OBJ semaphore = new OBJ();
       CountDownLatch doneSignal  = new CountDownLatch(threadSize);
        
       ProModel[] pros=new ProModel[threadSize];
      
       //设置特定的线程池，大小为threadSizde
       System.out.println("begins!");
       ExecutorService exe = Executors.newFixedThreadPool(threadSize);
       for(int i=0;i<threadSize;i++)
        exe.execute(new ProModel(i+1,doneSignal,N,semaphore));
 
           try{
              doneSignal.await();            //等待end状态变为0，           
              }catch (InterruptedException e) {
              // TODO: handle exception35           
              e.printStackTrace();       
           }finally{
                  System.out.println("ends!");
                  System.out.println(4*(float)ProModel.getTotal()/(float)(threadSize*N));
           }
           exe.shutdown();
             
           long end=System.currentTimeMillis();
           System.out.println("used time(ms):"+(end-begin));
       }
    }
class OBJ{}


/**
 * 线程run方法
 * @author zhuangzhewei
 *
 */
class ProModel implements Runnable {
	 
    public int N;//随机实验的总次数
    public static int M;//随机点落在圆中的次数
   
    private int id;
    private final CountDownLatch doneSignal;
    OBJ semaphore;
    public ProModel(int id,CountDownLatch doneSignal,int N,OBJ semaphore2){
       this.id=id;
       this.doneSignal=doneSignal;
       this.N=N;
       this.semaphore=semaphore2;
       M=0;
    }
    public void run(){
      
           int tempM=0;
           for(int i=0;i<N;i++){
              if(isInCircle()){
                  tempM++;
              }
           }
           synchronized (semaphore) {
              add(tempM);
           }  
           doneSignal.countDown();//使end状态减1
    }
   
    public  void add(int tempM){
       System.out.println(Thread.currentThread().getName());
       M=M+tempM;
       System.out.println(M);
    }
    //随机产生一个在正方形区域的点，判断它是否在圆中
    public boolean isInCircle(){
      
       double x=Math.random();
       double y=Math.random();
      
       if((x-0.5)*(x-0.5)+(y-0.5)*(y-0.5)<0.25)
           return true;
       else
           return false;
    }
    public static int getTotal(){
       return M;
    }
}