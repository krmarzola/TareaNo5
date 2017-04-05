/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram5.utilitarios;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class LectorArchivo 
{
    
    /**
     * MEtodo que lee la informacion ingresada por el request
     * @param archivo archivo y/o String de datos de entrada
     * @return retorna el listado de parametros ingresados en una Lista tipo double
     * @throws IOException Error al leer los datos ingresados
     */
    public LinkedList<Double> leerArchivoPlano(String archivo) throws IOException
   {
       LinkedList<Double> listadoDeValores = new LinkedList<Double>();
       String linea;
       try 
       {
           
           BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(archivo.getBytes()))); 
           try
           {
               while ((linea = br.readLine()) != null) 
               {
                   String[] numeros = linea.split(";");
                   Double X = Double.parseDouble(numeros[0]);
                   Double dof = Double.parseDouble(numeros[1]);
                   Double numSeg = Double.parseDouble(numeros[2]);
                   listadoDeValores.add(X);
                   listadoDeValores.add(dof);
                   listadoDeValores.add(numSeg);
               }         
           }
            catch (IOException ex) 
           {
               System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): Error al leer el archivo " + ex.getMessage());
           }
           finally 
           {
             br.close();
           }
       } 
       catch (FileNotFoundException ex) 
       {
           System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): no fue leido correctamento, por favor"
                   + "valide que es un archivo con extensión .txt");
       }
      return listadoDeValores;
   }   
    
    /**
    * Método que lee el archivo cargado
    * @param archivo Objeto de tipo File con información del archivo cargado
    * @return Objeto tipo HashMap con listas enlazadas de cada uno de los datos X y Y
    * @throws IOException Error al leer el archivo
    */
   public LinkedList<Double> leerArchivoPlano(File archivo) throws IOException
   {
       LinkedList<Double> listadoDeValores = new LinkedList<Double>();
       String linea;
       try 
       {
           BufferedReader br = new BufferedReader(new FileReader(archivo)); 
           try
           {
               while ((linea = br.readLine()) != null) 
               {
                   String[] numeros = linea.split(";");
                   Double numeroX = Double.parseDouble(numeros[0]);
                   Double numeroY = Double.parseDouble(numeros[1]);
                   listadoDeValores.add(numeroX/numeroY);
               }         
           }
            catch (IOException ex) 
           {
               System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): Error al leer el archivo " + archivo.getAbsolutePath() + ex.getMessage());
           }
           finally 
           {
             br.close();
           }
       } 
       catch (FileNotFoundException ex) 
       {
           System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): El archivo " + archivo.getAbsolutePath() + "no fue leido correctamento, por favor"
                   + "valide que es un archivo con extensión .txt");
       }
      return listadoDeValores;
   }
    
    /**
     * Método que recibe el valor ingresado por consola
     * @return numero tipo Double con el valor ingresado por consola
     * @throws Exception Error al ejecutar el metodo
     */
    public Double solicitarParametroPorConsola() throws Exception
    {
        Double valor = 0.0;
        try 
        {  
            Scanner teclado = new Scanner (System.in);
            System.out.println ("Escriba el valor de tamaño estimado Xk: ");
            valor = teclado.nextDouble();
        } 
        catch (Exception ex) 
        {
            System.out.println("pspprogram1.utilities.LectorDeArchivo.solicitarParametroPorConsola(): El valor ingresado " + valor + "no fue leido correctamento, por favor valide que es valor tipo double");
        }
       return valor;
    }
    
}
