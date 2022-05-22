/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
/**
 *
 * @author Faisan_Pykasu
 */
public class Conexion {
    private static final  String url ="jdbc:mysql://localhost:3306/comercio";
    private static final  String username ="root";
    private static final  String password ="root";
    
    public static Connection getConexion(){
      Connection conn=null;
        try {
              
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    
}
