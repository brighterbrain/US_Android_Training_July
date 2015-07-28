package com.javacodegeeks.javabasics.trycatch;

import java.util.ArrayList;
import java.util.List;

public class JavaTryCatchExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(0);
		
		try{
			System.out.println("A list element is: "+list.get(5));
			
			int x = list.get(1);
			int y = list.get(2);
			
			System.out.println("Division of x/y is: "+(x/y));
                        
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}finally{
			System.out.println("I will be executed, no matter what :-)");
		}
		
	}
}