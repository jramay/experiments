package com.jaffar.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	private final Lock lock = new ReentrantLock();
    private int count = 0;

     public int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
            return count++;
        } finally {
            lock.unlock();
        }
     }
     public static void main(String args[]) {
         
    	 ReentrantLockExample counter = new ReentrantLockExample();
         Runnable runable1 = () -> {
        	 
        	 Thread.currentThread().setName("Thread 1");
        	 while (counter.getCount() < 6) {
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException ex) {
                     ex.printStackTrace();                    }
             }
         };
         Runnable runable2 = () -> {
        	 
        	 Thread.currentThread().setName("Thread 2");
        	 while (counter.getCount() < 6) {
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException ex) {
                     ex.printStackTrace();                    }
             }
         };
         ExecutorService executor = Executors.newFixedThreadPool(10);
         executor.execute(runable1);
         executor.execute(runable2);
         
        
       
     }


 


}
