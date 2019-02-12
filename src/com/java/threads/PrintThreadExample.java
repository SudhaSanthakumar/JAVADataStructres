package com.java.threads;

public class PrintThreadExample {

	public static void main(String s[]){
		
		PrintThread pthread=new PrintThread();
		pthread.start();
		
		System.out.println(Thread.currentThread().getName());
		
		Thread pthreadOne=new Thread (new PrintThreadOne());
		pthreadOne.start();
		
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		
		
	}
}

class PrintThread extends Thread{
	public void run(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("From Thread "+Thread.currentThread().getName());
	}
}

class PrintThreadOne implements Runnable{
	public void run(){
		sleep(1000);
		System.out.println("From Runnable "+Thread.currentThread().getName());
	}

	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
}