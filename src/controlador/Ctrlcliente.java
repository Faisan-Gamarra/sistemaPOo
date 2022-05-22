/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Consultacliente;
import vista.Frmcliente;

/**
 *
 * @author Faisan_Pykasu
 */
public class Ctrlcliente implements ActionListener{
   private Clientes cli;
   private Consultacliente modC;
   private Frmcliente frm;

    public Ctrlcliente(Clientes cli, Consultacliente modC, Frmcliente frm) {
        this.cli = cli;
        this.modC = modC;
        this.frm = frm;
       this.frm.btninsert.addActionListener(this);
       this.frm.btneditar.addActionListener(this);
       this.frm.btnborrar.addActionListener(this);
       this.frm.btnbuscar.addActionListener(this);
       
        
    }
    public void iniciarproductos(){
        frm.setTitle("clientes");
        frm.setLocationRelativeTo(null);
    }
    public void limpiar(){
        frm.txtid.setText(null);
        frm.txtnombre.setText(null);
        frm.txtdir.setText(null);
        frm.txttel.setText(null);
        frm.txtci.setText(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==frm.btninsert){
             cli.setId(Integer.parseInt(frm.txtid.getText()));
             cli.setNombre(frm.txtnombre.getText());
             cli.setCi(Integer.parseInt(frm.txtci.getText()) );
             cli.setTelefono(Integer.parseInt(frm.txttel.getText()));
             cli.setDireccion(frm.txtdir.getText());
             if(modC.insert(cli)){
                 JOptionPane.showMessageDialog(null, "se inserto correctamente");
                 limpiar();
             }else{
                 JOptionPane.showMessageDialog(null, "error al insertar");
                 limpiar();
             }
                 
            }
             if(e.getSource()==frm.btneditar){
             cli.setId(Integer.parseInt(frm.txtid.getText()));
             cli.setNombre(frm.txtnombre.getText());
             cli.setCi(Integer.parseInt(frm.txtci.getText()) );
             cli.setTelefono(Integer.parseInt(frm.txttel.getText()));
             cli.setDireccion(frm.txtdir.getText());
             if(modC.editar(cli)){
                 JOptionPane.showMessageDialog(null, "se edito correctamente");
                 limpiar();
             }else{
                 JOptionPane.showMessageDialog(null, "error al editar");
                 limpiar();
             }
                 
            }
             if(e.getSource()==frm.btnborrar){
             cli.setId(Integer.parseInt(frm.txtid.getText()));
            
             if(modC.eliminar(cli)){
                 JOptionPane.showMessageDialog(null, "se elimino correctamente");
                 limpiar();
             }else{
                 JOptionPane.showMessageDialog(null, "error al eliminar");
                 limpiar();
             }
                 
            }
             if(e.getSource()==frm.btnbuscar){
             cli.setId(Integer.parseInt(frm.txtid.getText()));
            
             if(modC.buscar(cli)){
                frm.txtid.setText(String.valueOf(cli.getId()));
                frm.txtnombre.setText(String.valueOf(cli.getNombre()));
                frm.txtci.setText(String.valueOf(cli.getCi()));
                frm.txtdir.setText(String.valueOf(cli.getDireccion()));
                frm.txttel.setText(String.valueOf(cli.getTelefono()));
                
                
             }else{
                 JOptionPane.showMessageDialog(null, "No se encontro");
                 limpiar();
             }
                 
            }
    }
   
}
