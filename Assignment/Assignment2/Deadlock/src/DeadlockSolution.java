/**
 *@author:Sumitra
 *
 *Class to provide solution of deadlock
 *
 **/

public class DeadlockSolution {
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
            //lock 1 is kept by thread 1 so it can't be held by any other
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (Lock2) {
            	// after lock1 thread1 will take lock2 and release them both
               System.out.println("Thread 1: Holding lock 1 & 2...");
            }
         }
      }
   }
   private static class ThreadDemo2 extends Thread {
      public void run() {
         synchronized (Lock1) {
        	 // after processing of thread 1 is completed locks are free and can be held by thread 2
            System.out.println("Thread 2: Holding lock 1...");
            try { Thread.sleep(10); }
            catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 2...");
            synchronized (Lock2) {
               System.out.println("Thread 2: Holding lock 1 & 2...");
            }
         }
      }
   } 
}