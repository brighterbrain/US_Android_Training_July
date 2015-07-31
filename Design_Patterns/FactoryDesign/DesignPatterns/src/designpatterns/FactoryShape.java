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
public class FactoryShape {
    
    public Shape getShape(String shapeType){
        if(shapeType==null){
        return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE"))
                return new Circle();
        else if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square();
        else if(shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle();
        else
        
        return null;
    }
    
}
