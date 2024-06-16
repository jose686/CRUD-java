
package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    String url="jdbc:mysql://localhost:3306/registro";
    String user="root";
    String pass="1234";    
    String driver="com.mysql.cj.jdbc.Driver";    
    Connection con;
    
      
    public Connection getConnection(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("Se a conectado a la BBDD");
            
        } catch (Exception e) {      
              System.out.println("No se a conectado Error");
        }
        return con;
    }
    
    
}
