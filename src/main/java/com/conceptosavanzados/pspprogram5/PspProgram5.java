/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram5;

import com.conceptosavanzados.pspprogram5.utilitarios.CalcularIntegral;
import com.conceptosavanzados.pspprogram5.vista.InterfazVista;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class PspProgram5 
{
     /**
        *  Clase Principal que cumple las funciones de controlador de la aplicación
        * @author Kevin Ray Marzola Otero
        * @param args the command line arguments
        * @throws java.io.IOException Error al cargar el archivo
        */
       public static void main(String[] args) throws IOException 
       {
           try
           {
               // TODO code application logic here
               LinkedList<Double> listadoDeValores = new InterfazVista().cargarArchivo();
               if(listadoDeValores.isEmpty())
               {
                   throw new Exception ("El listado de datos ingresados no pueden ser nulos ni vacíos");
               }
               String resultado = new CalcularIntegral().calcular(listadoDeValores.get(0), listadoDeValores.get(1).intValue(), listadoDeValores.get(2).intValue());
               System.out.println("Para los valores ingresados. El rango de tamaño es el siguiente \n" + resultado); 
           }
           catch(IOException e)
           {
               System.out.println("Error al cargar archivo " + e.getMessage());            
           }
           catch (Exception e)
           {
               System.out.println("Error al ejecutar el programa " + e.getMessage());          
           }
       }
    
}
