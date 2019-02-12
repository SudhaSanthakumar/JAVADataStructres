package com.java.threads;

public class ThreadJoinExample {
	

	
		public static void main(String s[]){
			
			JoinThread pthread=new JoinThread();
			pthread.start();
			
			System.out.println(Thread.currentThread().getName());
			
			try {
				pthread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread pthreadOne=new Thread (new JoinThreadOne());
			pthreadOne.start();
			
			System.out.println(Thread.currentThread().isAlive());
			System.out.println(Thread.currentThread().getName());
			
			
			
		}
	}

	class JoinThread extends Thread{
		public void run(){
			try {
				for (int i=0;i<5;i++){
					System.out.println("From Thread "+Thread.currentThread().getName() + "  " + i);
				
					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	class JoinThreadOne implements Runnable{
		public void run(){
			for (int i=0;i<5;i++){
				
				System.out.println("From Runnable "+Thread.currentThread().getName() + "  " + i);
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
	}

