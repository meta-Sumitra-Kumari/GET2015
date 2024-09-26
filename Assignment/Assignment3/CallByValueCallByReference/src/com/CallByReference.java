
package com;

/**
 * @author Sumitra
 * 
 * Class to show usage of call by reference
 *
 */
public class CallByReference {
	 int value=50;  
	  
	 void change(CallByReference op){  
	 op.value=op.value+100;//changes will be in the instance variable  
	 System.out.println("in function "+op.value); 
	 }  
	     
	    
	 public static void main(String args[]){  
		 CallByReference callByReference=new CallByReference();  
	  
	   System.out.println("before change "+callByReference.value);  
	   callByReference.change(callByReference);//passing object  
	   System.out.println("after change "+callByReference.value);  
	  
	 }  
}
