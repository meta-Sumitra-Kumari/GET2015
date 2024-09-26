/**
 *@author:Sumitra
 *
 *Class to create a deadlock
 *
 **/

public class DeadlockExample {

   public static String Lock1 = "lock1";
   public static String Lock2 = "lock2";

	public static void main(String args[]) {

		ThreadDemo1 T1 = new ThreadDemo1();
		ThreadDemo2 T2 = new ThreadDemo2();
		T1.start();
		T2.start();
	}

	private static class ThreadDemo1 extends Thread {
		public void run() {
			synchronized (Lock1) {
				System.out.println("Thread 1: Holding lock 1...");
				// lock 1 is held by thread one
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for lock 2...");
				synchronized (Lock2) {
					// can't reach at this level,as lock2 is held by thread 2 
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}

	private static class ThreadDemo2 extends Thread {
		public void run() {
			synchronized (Lock2) {
				System.out.println("Thread 2: Holding lock 2...");
				// lock 2 is held by thread one
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 2: Waiting for lock 1...");
				synchronized (Lock1) {
					// can't reach at this level,as lock1 is held by thread 1 
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	}
}
