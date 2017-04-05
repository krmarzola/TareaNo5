/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram5.controlador;

import com.conceptosavanzados.pspprogram5.utilitarios.CalcularIntegral;
import com.conceptosavanzados.pspprogram5.utilitarios.LectorArchivo;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet 
{
    private LectorArchivo archivo = new LectorArchivo();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request request al servlet
     * @param response respuesta del servlet
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException Error al revibir la información del request
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String datos = (String) request.getParameter("datosIngresados");
        try 
        {
            LinkedList<Double> listadoDeValores = archivo.leerArchivoPlano(datos);
            if (listadoDeValores.isEmpty()) 
            {
                throw new Exception("El listado de datos ingresados no pueden ser nulos ni vacíos");
            }
            CalcularIntegral resultado = new CalcularIntegral();
            resultado.calcular(listadoDeValores.get(0), listadoDeValores.get(1).intValue(), listadoDeValores.get(2).intValue());
            request.setAttribute("resultados", resultado);

        } 
        catch (Exception e) 
        {
            request.setAttribute("mensajeError", e);
        }
        RequestDispatcher rs = request.getRequestDispatcher("respuesta.jsp");
        rs.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}