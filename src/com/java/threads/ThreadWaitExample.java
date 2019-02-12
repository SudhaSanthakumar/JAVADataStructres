package com.java.threads;

public class ThreadWaitExample {

		String name="Hello World!";
		public static void main(String s[]){
			
			WriterThread pthread=new WriterThread();
			pthread.start();
			
			System.out.println(Thread.currentThread().getName());
			
			try {
				pthread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread pthreadOne=new Thread (new ReaderThread());
			pthreadOne.start();
			
			System.out.println(Thread.currentThread().isAlive());
			System.out.println(Thread.currentThread().getName());
			
			
			
		}
		
		public void write(){
			synchronized(this){
				
			    name.concat("  vanakam ");
			}
		}
		public void read(){
			System.out.println("name is   "+name);
		}
	}

	class WriterThread extends Thread{
		public void run(){
			ThreadWaitExample t=new ThreadWaitExample();
			t.write();
			
		}
	}

	class ReaderThread implements Runnable{
		public void run(){
			ThreadWaitExample t=new ThreadWaitExample();
			t.read();
		}

		
	}


