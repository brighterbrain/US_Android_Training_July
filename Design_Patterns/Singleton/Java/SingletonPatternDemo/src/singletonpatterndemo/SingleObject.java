/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpatterndemo;

/**
 *
 * @author kalpesh
 */
public class SingleObject {
//Step 1: Create a static object of class
    private static SingleObject instance=new SingleObject();
    
//Step 2: Create the private constructor of the class so that this class
// cannaot be instantiated
    private SingleObject(){}
    //Step 3: Create a static method which returns object of the class

    public static synchronized SingleObject getInstance()
	{
		if (instance == null)
			instance = new SingleObject();

		return instance;
	}
   
    
    public void showMessage(){
    System.out.println("I AM CALLED FROM Singleton class");
    }
}
    

