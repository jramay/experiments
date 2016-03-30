package com.jaffar.practice.concurrency;

public class DaemonTest {

    public static void main(String[] args) {
        new WorkerThread("WORKER 1",true).start();
        
       // new WorkerThread("WORKER 2", false).start();

        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            // handle here exception
        }

        System.out.println("Main Thread ending") ;
    }

}

class WorkerThread extends Thread {

	boolean daemonStatus;
    public WorkerThread(String name, boolean daemon) {
        // When false, (i.e. when it's a user thread),
        // the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the Worker thread terminates when the main 
        // thread terminates.
    	daemonStatus = daemon;
        setDaemon(daemon); 
        setName(name);
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from "+getName()+" ("+daemonStatus+") "+count++);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                // handle exception here
            }
            /*
            if(count>10 && !daemonStatus){
            	break;
            }
            */
        }
    }
}
