/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapoo;

import controlador.CtrlProducto;
import modelo.ConsultasProducto;
import modelo.Productos;
import vista.Frmproducto;

/**
 *
 * @author Faisan_Pykasu
 */
public class SistemaPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Productos mod= new Productos();
        ConsultasProducto modC= new ConsultasProducto();
        Frmproducto frm=new Frmproducto();
        CtrlProducto ctrl=new CtrlProducto(mod,modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
