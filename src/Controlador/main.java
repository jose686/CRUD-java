/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaCrud;
import java.util.ArrayList;
import java.util.List;



public class main {

        //Persona p = new Persona();
   


    public static void main(String[] args) {
     
         PersonaCrud pc =new PersonaCrud();
          List<Persona>  p = pc.listar();
          
       
          for (Persona per : p ){
               System.out.println("id "+ per.getId());
              System.out.println("DNI"+ per.getDNI());
              System.out.println("Nombre "+ per.getNombres());
          }
            
    
            
            
            
        
     //  System.out.println(  pc.listar());
        
    }
    
    
   
    
    
    
    
    
}
