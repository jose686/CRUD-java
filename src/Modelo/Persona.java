/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Persona {
    int id;
    String DNI;
    String Nombres;

    public Persona() {
    }
    
    
    
    

    public Persona(int id, String DNI, String Nombres) {
        this.id = id;
        this.DNI = DNI;
        this.Nombres = Nombres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getId() {
        return id;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombres() {
        return Nombres;
    }
    
    
    
    
}
