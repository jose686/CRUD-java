/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaCrud;
import Vista.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Controlador implements ActionListener{
    
    vistaPrincipal vista = new vistaPrincipal();
    Persona p = new Persona();
    PersonaCrud pc = new PersonaCrud();
    DefaultTableModel modelo ;
    
    



    public Controlador( vistaPrincipal v) {
       this.vista = v;
       this.vista.btnlistar.addActionListener(this);
       this.vista.btnnuevo.addActionListener(this);
       this.vista.btneliminar.addActionListener(this);
       this.vista.txtdni.addActionListener(this);      
       this.vista.txtnombres.addActionListener(this);
               
            
        
    }
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
     
        if (e.getSource() == vista.btnlistar) {
            System.out.println("clikc btnlistar");
            listar(vista.tabladatos);
          //add();
            System.out.println("Controlador.Controlador.actionPerformed()");
            }
  
         if (e.getSource() == vista.btnnuevo) {
            System.out.println("clikc btnnuevo");
            add();
            listar(vista.tabladatos);
             }
           
            if (e.getSource() == vista.btneliminar) {
            System.out.println("clikc btneliminar");
            delete();
            listar(vista.tabladatos);

            
           
        }
        
         
    }
        
        
       public void delete() {
        int fila = vista.tabladatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe Seleccionar una Fila...!!!");
        } else {
            int id = Integer.parseInt((String) vista.tabladatos.getValueAt(fila, 0).toString());
            pc.eliminar(id);
            System.out.println("El Reusltaod es" + id);
            JOptionPane.showMessageDialog(vista, "Usuario Eliminado...!!!");
        }
        limpiarTabla();
    }
        
        
        
        
          
     
        public void listar (JTable tabla){
            
             centrarCeldas(tabla);
            modelo = (DefaultTableModel) tabla.getModel();
            tabla.setModel(modelo);
            
            
            
            // PersonaCrud pc =new PersonaCrud();
              List<Persona>  p = pc.listar();
               Object[] objeto = new Object[3];
       
          for (Persona per : p ){
              objeto[0]=per.getId();
              objeto[1]=per.getDNI();
              objeto[2]=per.getNombres();
                
              modelo.addRow(objeto);
            
          }
            
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
            
            
        }
        
        
        public void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabladatos.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
 
        
        
        
        
        
    
    
    
    public void add(){
       String dni = vista.txtdni.getText();
       String Nombre =vista.txtnombres.getText();
        p.setDNI(dni);
        p.setNombres(Nombre);
        int r = pc.agregar(p);
         if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario Agregado con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
        
    }
    
      void limpiarTabla() {
        for (int i = 0; i < vista.tabladatos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    
    
}
