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
public class ConsultasProducto extends Conexion  {
    public boolean insertar (Productos pro) {
       PreparedStatement ps=null; 
       Connection con=getConexion();
       String sql="insert into productos (id,Descripcion,precio,iva,cantidad,categoria,Fechavec) values(?,?,?,?,?,?,?)";
        try {
          ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getPrecio());
            ps.setInt(4, pro.getIva());
            ps.setInt(5, pro.getCantidad());
            ps.setInt(6, pro.getCategoria());
             ps.setString(7, pro.getFecha());
          ps.execute();
          return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
                    
    }
     public boolean modificar (Productos pro) {
       PreparedStatement ps=null; 
       Connection con=getConexion();
       String sql="update productos set id=?,Descripcion=?,precio=?,iva=?,cantidad=?,categoria=?,Fechavec=? where id=?";
        try {
          ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getPrecio());
            ps.setInt(4, pro.getIva());
            ps.setInt(5, pro.getCantidad());
            ps.setInt(6, pro.getCategoria());
             ps.setString(7, pro.getFecha());
             ps.setInt(8, pro.getId());
          ps.execute();
          return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
                    
    }
     public boolean eliminar (Productos pro) {
       PreparedStatement ps=null; 
       Connection con=getConexion();
       String sql="delete from productos  where id=?";
        try {
          ps=con.prepareStatement(sql);
          
             ps.setInt(1, pro.getId());
          ps.execute();
          return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
                    
    }
     public boolean buscar (Productos pro) {
       PreparedStatement ps=null; 
       ResultSet rs=null;
       Connection con=getConexion();
       String sql="select * from productos  where id=?";
        try {
          ps=con.prepareStatement(sql);
          
             ps.setInt(1, pro.getId());
          rs= ps.executeQuery();
          if(rs.next()){
              pro.setId(rs.getInt(1));
              pro.setDescripcion(rs.getString(2));
              pro.setPrecio(rs.getInt(3));
              pro.setIva(rs.getInt(4));
              pro.setCantidad(rs.getInt(5));
              pro.setCategoria(rs.getInt(6));
              pro.setFecha(rs.getString(7));
              return true;
          }
          return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
            
                    
    }
}
