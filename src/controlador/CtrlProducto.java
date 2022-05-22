/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Productos;
import vista.Frmproducto;

/**
 *
 * @author Faisan_Pykasu
 */
public class CtrlProducto implements ActionListener{
    private Productos mod;
    private ConsultasProducto modC;
    private Frmproducto frm;
    
    public CtrlProducto(Productos mod, ConsultasProducto modC, Frmproducto frm){
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        this.frm.btnbuscar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
        this.frm.btninsertar.addActionListener(this);
        this.frm.btnmodicar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed( ActionEvent e){
        if(e.getSource()==frm.btninsertar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            mod.setDescripcion(frm.txtdescripcion.getText());
            mod.setPrecio(Integer.parseInt(frm.txtprecio.getText()));
             mod.setIva(Integer.parseInt(frm.txtiva.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtcan.getText()));
            mod.setCategoria(Integer.parseInt(frm.txtcat.getText()));
            mod.setFecha(frm.txtvec.getText().toString());
            if(modC.insertar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnmodicar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
            mod.setDescripcion(frm.txtdescripcion.getText());
            mod.setPrecio(Integer.parseInt(frm.txtprecio.getText()));
            mod.setIva(Integer.parseInt(frm.txtiva.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtcan.getText()));
            mod.setCategoria(Integer.parseInt(frm.txtcat.getText()));
            mod.setFecha(frm.txtvec.getText().toString());
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        if(e.getSource()==frm.btneliminar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
           
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Borrar");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnbuscar){
            mod.setId(Integer.parseInt(frm.txtid.getText()));
           
            if(modC.buscar(mod)){
                frm.txtid.setText(String.valueOf(mod.getId()));
                frm.txtdescripcion.setText(mod.getDescripcion());
                frm.txtprecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtiva.setText(String.valueOf(mod.getIva()));
                frm.txtcan.setText(String.valueOf(mod.getCantidad()));
                frm.txtcat.setText(String.valueOf(mod.getCategoria()));
                frm.txtvec.setText(mod.getFecha());
                
                
               
            }else{
                JOptionPane.showMessageDialog(null, "Registro no encontrado");
                limpiar();
            }
        }
    }
    public void limpiar(){
        frm.txtid.setText(null);
        frm.txtdescripcion.setText(null);
        frm.txtprecio.setText(null);
        frm.txtcan.setText(null);
        frm.txtcat.setText(null);
        frm.txtvec.setText(null);
        
    }
}
