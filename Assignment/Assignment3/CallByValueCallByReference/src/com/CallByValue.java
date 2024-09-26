
package com;

/**
 * @author Sumitra
 * class to show usage of call by value
 *
 */
class CallByValue{  
	 int value=50;  
	  
	 void change(int value){  
	 value=value+100;//changes will be in the local variable only 
	 System.out.println("value in function "+value); 
	 }  
	     
	 public static void main(String args[]){  
	   CallByValue callByValue=new CallByValue();  
	  //
	   System.out.println("before change "+callByValue.value);  
	   callByValue.change(500);  
	   System.out.println("after change "+callByValue.value);  
	  
	 }  
	}  