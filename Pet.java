/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project;

/**
 *
 * @author User
 */
public class Pet {

   
    private String ID,Type,Name;
    
    Pet(String ID,String type,String name){
        this.ID=ID;
        this.Type=type;
        this.Name=name;
    }
   void setID(String ID){
        this.ID= ID;
    }
     void setType(String type){
        this.Type=type;
    }
      void setName(String name){
        this.Name=name;
     }
      String getID(){
          return ID;
      }
    String getType(){
        return Type;
    }
    String getName(){
        return Name;
    }
}
