/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram5.vista;
import com.conceptosavanzados.pspprogram5.utilitarios.LectorArchivo;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class InterfazVista 
{
    /**
    * Método que emula el comportamiento de una vista donde se carga el archivo
    * @return Objeto de tipo Map que contiene listas enlazadas de tipo double con el listado de numeros
    * @throws IOException Error en la lectura del archivo 
    */ 
   public LinkedList<Double> cargarArchivo() throws IOException 
   {
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        File archivoCargado;
        j.showOpenDialog(j);
        LinkedList<Double> listadoDeValores = new LinkedList<Double>();
        try 
        {
            String path = j.getSelectedFile().getAbsolutePath();
            archivoCargado = new File(path);
            try 
            {
                LectorArchivo archivo = new LectorArchivo();
                listadoDeValores = archivo.leerArchivoPlano(archivoCargado);
            } 
            catch (IOException e) 
            {
              javax.swing.JOptionPane.showMessageDialog(j, "Error en la lectura del archivo: " + e.getMessage());
              System.exit(0);
            } 
            return listadoDeValores;
        } 
        catch (NullPointerException e) 
        {
           javax.swing.JOptionPane.showMessageDialog(j, "Ha finalizado la ejecución");
            System.exit(0);
        }
        return listadoDeValores;
   }
    
}
