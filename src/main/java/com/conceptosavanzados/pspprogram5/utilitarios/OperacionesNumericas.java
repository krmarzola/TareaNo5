/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram5.utilitarios;

import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class OperacionesNumericas 
{
    /**
    * Método calcula la media de un LinkedList tipo double
    * @param listaDeNumeros listado de numeros
    * @return retorna la media calcula de variable tipo double
    */
    public static double calcularMedia(LinkedList<Double> listaDeNumeros)
    { 
        double sumatoria = 0;
        for(double valor : listaDeNumeros)
        {
            sumatoria += valor;
        }
        return ((double)sumatoria/(double)listaDeNumeros.size());    
    }
    
    /**
    * Metodo calcula la productoria de dos LinkedList tipo double
    * @param valoresX es un LinkedList tipo double
    * @param valoresY es un LinkedList tipo dobule
    * @return variable de tipo double
    */    
    public static double calcularProductoria(LinkedList<Double> valoresX, LinkedList<Double> valoresY)
    {
        if(valoresX.size() != valoresY.size())
        {
            System.out.println("los arreglos no tienen el mismo tamaño");
            System.exit(2);
        }
        
        int totalNumeros = valoresX.size();
        double acumulador = 0D;
        for(int indiceMultiplicacion = 0; indiceMultiplicacion< totalNumeros; indiceMultiplicacion++)
        {
            acumulador += valoresX.get(indiceMultiplicacion)*valoresY.get(indiceMultiplicacion);
        }
        
        return acumulador;
    }
    
    /**
    * Metodo calcula la sumatoria de un LinkedList tipo double
    * @param valoresX es un LinkedList tipo double
    * @return variable de tipo double 
    */     
    public static double calcularSumatoria(LinkedList<Double> valoresX)
    {
        double acumulador = 0;
        for(Double valor : valoresX)
        {
            acumulador +=valor;             
        }
        return acumulador;
    }
    
    /**
    * Metodo que calcula la productoria de un Arraylist tipo double
    * @param valoresX es un ArrayList tipo double
    * @return variable de tipo double
    */      
    public static double calcularProductoria(LinkedList<Double> valoresX)
    {
        if(valoresX.size() != valoresX.size())
        {
            System.out.println("los arreglos no tienen el mismo tamaño");
            System.exit(2);
        }
        int totalNumeros = valoresX.size();
        double acumulador = 0D;
        for(int indiceMultiplicacion = 0; indiceMultiplicacion< totalNumeros; indiceMultiplicacion++)
        {
            acumulador += valoresX.get(indiceMultiplicacion)*valoresX.get(indiceMultiplicacion);
        }
        return acumulador;
    }
    /**
     * Método que calcula la sumatoria de logaritmo natural de un listado de valores
     * @param valores lista de valores tipo double
     * @return Valor tipo double
     */
    public static double calcularLn(LinkedList<Double> valores)
    {	
        double acumulador = 0;
        for(double valor : valores)
        {
            acumulador += Math.log(valor);
        }
        return acumulador;
    }
    /**
     * Metodo que calcula la sumatoria de logaritmo natural sobre el promedio
     * @param valores listado de valores 
     * @param AVG parametro AVG
     * @return variable de tipo double
     */
    public static double calcularLnAVG(LinkedList<Double> valores, double AVG)
    {	
        double acumulador = 0;
        for(double valor : valores)
        {
            acumulador += Math.pow((Math.log(valor) - AVG),2);
        }
        return acumulador;
    }
    
    /**
     * Metodo que calcula el valor Gamma a partir de los dof
     * @param dof grados de libertad
     * @return parametro Gamma de tipo double
     */
    public static double calcularGama(double dof)
    {	
        int parteEntera= (int)dof;
        double resultado = 1;		 
        double ParteDecimal = dof - parteEntera;

        if(ParteDecimal == 0)
        {
            parteEntera -=1;
            for(int indice = parteEntera; indice > 1; indice--)
            {
                resultado *= indice;
            }
            return resultado;
        }
        else
        {
            return gamma(dof);
        }
    }
    
    /**
     * Metodo que calcula el valor gamma realizando un despeje de la ecuación de F(X = 0)
     * @param dof parametros de grados de libertad
     * @return  variable tipo double
     */
    private static double gamma(double dof) 
    { 
        return Math.exp(logGamma(dof)); 
    }

    /**
     * Metodo que calcula el valor de Gamma continuando el despeje de la ecuación de F(X = 0)
     * @param dof parametros de grados de libertad
     * @return variable tipo double
     */
    private static double logGamma(double dof) 
    {
        double tmp = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
        double ser = 1.0 + 76.18009173 / (dof + 0) - 86.50532033 / (dof + 1) + 24.01409822 / (dof + 2) - 1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
        return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }
    
    /**
     * Metodo que calcula el valor de F(x) para una interacción
     * @param dofexterno grados de libertad (dof)
     * @param xi valor de la interaccion 
     * @return variable de tipo double con el valor de F(x) para esta interacción
     */
    public static double calcularFx(int dofexterno, double xi)
    {	
        double dof = dofexterno;
        double parteA = calcularGama((dof+1)/2);
        double parteB = (Math.pow(dof*Math.PI,0.5))*(calcularGama(dof/2));
        double parteC = Math.pow((1+(Math.pow(xi,2)/dof)),(-(dof+1)/2));
        return (parteA/parteB)*parteC;
    }
    
}
