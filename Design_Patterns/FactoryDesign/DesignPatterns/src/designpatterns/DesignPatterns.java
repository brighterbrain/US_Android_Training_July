/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

/**
 *
 * @author kalpesh
 */
public class DesignPatterns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //STEP 1: Create Factory Object
        FactoryShape factShape= new FactoryShape();
        
        //STEP 2: Call objects using interface object
        Shape shape1=factShape.getShape("CIRCLE");
       
        //STEP 3: Call methods from factory
        shape1.draw();
        
        //STEP 2: Call objects using interface object
        Shape shape2=factShape.getShape("square");
       
        //STEP 3: Call methods from factory
        shape2.draw();
        //STEP 2: Call objects using interface object
        Shape shape3=factShape.getShape("Rectangle");
       
        //STEP 3: Call methods from factory
        shape3.draw();
        
    }
    
}
