package com.java.threads;

import java.util.Hashtable;

public class ProducerConsumerExample {

	
	int count=0;
	
	
	public static void main(String [] ags) {
		
		final ProducerConsumerExample p=new ProducerConsumerExample();
		Thread t1=new Thread(new Runnable() {
			
			public void run() {
				
				while(true){
					if (p.count<5 ) {
						p.count++;
						System.out.println("producing item = "+p.count);
						notify();
						}
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
Thread t2=new Thread(new Runnable() {
			
			public void run() {
				while(true){
					if (p.count>0) {
						System.out.println("consuming item = "+p.count);
						p.count--;
						notify();
					}
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
		});
t1.start();
t2.start();
		
	}

}
