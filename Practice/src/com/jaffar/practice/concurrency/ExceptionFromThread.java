package com.jaffar.practice.concurrency;
public class ExceptionFromThread implements Runnable{

	static int exceptionCount = 0;
	public synchronized static void exceptionIncrement(){
		exceptionCount++;
	}
	@Override
	public void run() {
		
		while(true){
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" Waiting...."+exceptionCount);
				if(exceptionCount==0){
					
					exceptionIncrement();
					throw new NullPointerException();
				}
			
		}
		
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new ExceptionFromThread());
		Thread thread2 = new Thread(new ExceptionFromThread());
		Thread thread3 = new Thread(new ExceptionFromThread());
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
