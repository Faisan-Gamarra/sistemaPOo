/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapoo;
import modelo.*;
import controlador.*;

import vista.Frmcliente;
/**
 *
 * @author Faisan_Pykasu
 */
public class clientes_principal {
    public static void main(String[] args) {
        Clientes mod = new Clientes();
        Consultacliente modC= new Consultacliente();
        Frmcliente frm = new Frmcliente();
        
         Ctrlcliente cliC = new Ctrlcliente(mod, modC, frm);
         
         cliC.iniciarproductos();
         frm.setVisible(true);
        
    }
}
