/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_pattern.model;

/**
 *
 * @author kalpesh
 */

/*
Model - Model represents an object or JAVA POJO carrying data. 
It can also have logic to update controller if its data changes.
*/
public class Student {
    
    //Step 1: Create POJO's for data
    private String rollNo;
    private String name;
    
    public String getRollNo(){
        return rollNo;
    }
    public void setRollNo(String rollNo){
        this.rollNo=rollNo;
    }
    
    
}
