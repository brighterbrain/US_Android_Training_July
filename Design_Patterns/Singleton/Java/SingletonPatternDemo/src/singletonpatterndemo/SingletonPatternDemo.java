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
public class SingletonPatternDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //illegal way:
       // compile type error: The constructor of SingleObject is not visible 
       // SingleObject object = new SingleObject();
        
       //Step 4:Get the only object available
        // The getInstance method is used also to provide a global point of access to the object and it can be used in the following manner:

        SingleObject object=SingleObject.getInstance();
        
        object.showMessage();
    }
    
}
