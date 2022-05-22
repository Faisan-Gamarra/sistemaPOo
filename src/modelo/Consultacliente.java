/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Faisan_Pykasu
 */
public class Consultacliente extends Conexion {
    public boolean insert(Clientes cli) {
        PreparedStatement ps=null;
        Connection con= getConexion();
            String sql="insert into clientes (id,nombre,cedula,direccion,telefono) values(?,?,?,?,?)";
            try {
                 con.prepareStatement(sql);
                ps.setInt(1, cli.getId());
                ps.setString(2, cli.getNombre());
                ps.setInt(3, cli.getCi());
                ps.setString(4, cli.getDireccion());
                ps.setInt(5, cli.getTelefono());
               
            ps.execute();
            return true;
        } 
            catch (SQLException e) {
                System.err.println(e);
              return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            }
        
    }
    public boolean editar(Clientes cli){
        PreparedStatement ps=null;
        Connection con= getConexion();
            String sql="update clientes set id=?,nombre=?,cedula=?,direccion=?,telefono=? where id=? ";
            try {
                 con.prepareStatement(sql);
                ps.setInt(1, cli.getId());
                ps.setString(2, cli.getNombre());
                ps.setInt(3, cli.getCi());
                ps.setString(4, cli.getDireccion());
                ps.setInt(5, cli.getTelefono());
                ps.setInt(6, cli.getId());
            ps.execute();
            return true;
        } 
            catch (SQLException e) {
                System.err.println(e);
              return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            }
        
    }
     public boolean buscar(Clientes cli){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con= getConexion();
        
            String sql="Select * from cliente where id=? ";
            try {
                 con.prepareStatement(sql);
                ps.setInt(1, cli.getId());
                
            rs=ps.executeQuery();
                if(rs.next()){
                    cli.setCi(rs.getInt(1));
                    cli.setNombre(rs.getString(1));
                    cli.setCi(rs.getInt(3));
                    cli.setDireccion(rs.getString(4));
                    cli.setTelefono(rs.getInt(5));
                    
                    return true;
                }
            return false;
        } 
            catch (SQLException e) {
                System.err.println(e);
              return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            }
            
        
    }
     public boolean eliminar(Clientes cli){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con= getConexion();
        
            String sql="delete  from cliente where id=? ";
            try {
                 con.prepareStatement(sql);
                ps.setInt(1, cli.getId());
                
                ps.execute();
                return true;
        } 
            catch (SQLException e) {
                System.err.println(e);
              return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            }
        
    }
}
