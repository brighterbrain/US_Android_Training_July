/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_pattern.controller;
import mvc_pattern.view.StudentView;
import mvc_pattern.model.Student;
/**
 *
 * @author kalpesh
 */
public class StudentController {
    //Step 2: Create the objects of model and view classes
    private Student model;
    private StudentView view;
    
    //Step 3: Create a constructor to instantiate above two classes objects
    public StudentController(Student model,StudentView view ){
        this.model=model;
        this.view=view;
    }
    
    //Step 4: Create setter methods to update model from view
     public void setStudentRollno(String rollNo){
         model.setRollNo(rollNo);
     }
    
     //Step 5: Create getter methods to get values from model to view
      public String getStudentRollNo(){
        return model.getRollNo();
    }
      
     public void updateView(){				
      view.printStudentDetails(model.getRollNo());
   }	
}
