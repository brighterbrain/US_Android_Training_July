/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_electricitybill;

/**
 *
 * @author kalpesh
 */
    class GetPlanFactory{  
          
       //use getPlan method to get object of type Plan   
           public Plan getPlan(String planType){  
                if(planType == null){  
                 return null;  
                }  
              if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
                     return new DomesticPlan();  
                   }   
               else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
                    return new CommercialPlan();  
                }   
              else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {  
                    return new InstitutionalPlan();  
              }  
          return null;  
       }  
    }//end of GetPlanFactory class.  