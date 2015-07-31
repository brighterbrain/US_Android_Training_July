/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.activity;
import mvc_pattern.controller.StudentController;
import mvc_pattern.model.Student;
import mvc_pattern.view.StudentView;

/**
 *
 * @author kalpesh
 */
public class MainActivity {
     public static void main(String[] args) {

      //fetch student record based on his roll no from the database
      Student model  = retriveStudentFromDatabase();

      //Create a view : to write student details on console
      StudentView view = new StudentView();

      StudentController controller = new StudentController(model, view);

      controller.updateView();

      //update model data
      controller.setStudentRollno("55");

      controller.updateView();
   }

   private static Student retriveStudentFromDatabase(){
      Student student = new Student();
      student.setRollNo("10");
      return student;
   }
   
}
