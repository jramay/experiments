package com.jaffar.practice.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;


public class SynchronousQueueDemo{ 
	public static void main(String args[]){ 
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		Runnable producer = () -> {
									Thread.currentThread().setName("PRODUCER");
									String event = "FOUR";
									try {
										queue.put(event);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
									};
		Runnable consumer = () -> {
									Thread.currentThread().setName("CONSUMER");
									String event ="";
									try {
										event = queue.take();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} // thread will block here
									System.out.printf("[%s] consumed event : %s %n", Thread .currentThread().getName(), event);
										};
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(producer);
		executor.execute(consumer);
		
					
	}
				
}
		



