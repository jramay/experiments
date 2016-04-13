package com.jaffar.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyTest {

	public static void main(String[] args) {
        Message msg = new Message("process it");
        
        Runnable waiter = () -> {
        	Thread.currentThread().setName("WAITER");
        	String name = Thread.currentThread().getName();
            synchronized (msg) {
                try{
                    System.out.println(name+" waiting for notification at: "+System.currentTimeMillis());
                    
                    msg.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(name+" got notification at: "+System.currentTimeMillis());
                //process the message now
                System.out.println(name+" processed: "+msg.getMsg());
            }
        };
        
        Runnable notifier = () -> {
        	Thread.currentThread().setName("NOTIFIER");
        	String name = Thread.currentThread().getName();
            System.out.println(name+" started");
            try {
                Thread.sleep(1000);
                synchronized (msg) {
                    msg.setMsg(name+" Notifier work done");
                    msg.notify();
                    System.out.println(name+" sent notification at time:"+System.currentTimeMillis());
                    // msg.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name+" ended");
        };
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(waiter);
        executor.submit(notifier);
        
    }
}

class Message {
    private String msg;
     
    public Message(String str){
        this.msg=str;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String str) {
        this.msg=str;
    }
 
}