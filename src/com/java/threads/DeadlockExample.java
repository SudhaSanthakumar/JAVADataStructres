package com.java.threads;

public class DeadlockExample {
	
	Task s=new Task();
	
	public static void main(String [] ags) {
		
		final DeadlockExample d=new DeadlockExample();
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				System.out.println("calling add");
				d.s.add();
			}
			
		});
		
Thread t2=new Thread(new Runnable() {
			
			public void run() {
				System.out.println("calling sub");
				d.s.subtract();
			}
			
		});
t1.start();
t2.start();
		
	}

}
class Task{
	
	Integer a=new Integer(12);
	
	Integer b=new Integer(2);
	

	public void subtract() {
		synchronized(b){
			try {
				System.out.println("waiting for b");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(a){
				System.out.println(a-b);;
				//notifyAll();
			}
			
		}
		
	}


	public void add() {
		synchronized(a){
			try {
				
				System.out.println("waiting for a");
				//wait();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(b){
				System.out.println(a+b);;
				//notifyAll();
			}
			
		}
	}
	
}
