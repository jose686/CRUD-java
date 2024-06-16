package Modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class PersonaCrud {
    
    PreparedStatement ps;
    ResultSet rs ;
    Connection con;
    Conexion conectar =new Conexion();
    
    
    
    
     public int agregar(Persona per){
         
            Persona p = new Persona();
            p= per;
            
        int r=0;
        String sql="insert into persona(DNI,Nombres)values(?,?)"; 
         
        
      
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
           ps.setString(1, p.getDNI());
            ps.setString(2, p.getNombres());
            r=ps.executeUpdate();
            
                if(r==1){
                        return 1;
                          
                   }
                  else{
                return 0;
                     }

            
            
            
            
        } catch (Exception e) {
                 System.out.println("Error al agregar ");
        }
         
        
        
        return r;
     }
    
    
    
    public List listar (){
        String busqueda = "select*from persona;";
        List <Persona> datos = new ArrayList<>();
        
        try{
        con = conectar.getConnection();
        ps = con.prepareStatement(busqueda);
            
            rs = ps.executeQuery();
            
            if(!rs.isBeforeFirst()){
                System.out.println("El resultset esta vacio");
            }else{
                while(rs.next()){
                    Persona p =new Persona();
                    p.setId(rs.getInt(1));
                    p.setDNI(rs.getString(2));
                    p.setNombres(rs.getString(3));
                   datos.add(p);
                }
            }
         rs.close();
         ps.close();
            System.out.println("Los datos se cargaron correctamente");
            
        }catch(Exception e){
        
            System.out.println("ERROR AL LEER LOS DATOS");   
            
            
            
        }
        
        
        
        
        return datos;
    }
    public int eliminar (int id) {
        int r=0;
        String sql="delete from persona where Id="+id;
        
       
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
             r = ps.executeUpdate();
             System.out.println("Se a eliminado correctamente");
        } catch (Exception ex) {
              System.out.println("No se a eliminado correctamente");
        }
  
        
        
        
        return r;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
