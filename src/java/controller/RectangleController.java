/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Calculators;
import model.ICircleCalculator;
import model.IRectangleCalculator;

/**
 *
 * @author scottodya
 */
@WebServlet(name = "RectangleController", urlPatterns = {"/RectangleController"})
public class RectangleController extends HttpServlet {
    private static final String DESTINATION = "/index.jsp";
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // parameters are name attributes in view pages
        // Here we're retrieving form content from form.html
        String s1 = request.getParameter("length");
        String s2 = request.getParameter("width");
        
        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        IRectangleCalculator irc = new Calculators();
        // Always a good idea to trim and/or validate input data
        double result = irc.calculateRectangleArea(s1.trim(), s2.trim());

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("answer_rectangle", result);
        
        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(DESTINATION);
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
