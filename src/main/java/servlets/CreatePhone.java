/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Phone;

/**
 *
 * @author user
 */
@WebServlet(name = "CreatePhone", urlPatterns = {"/CreatePhone"})
public class CreatePhone extends HttpServlet {

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
        int costumerId = Integer.parseInt(request.getParameter("costumerId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String number = request.getParameter("number");
        
        Phone phone = new Phone(costumerId, typeId, number);
        
        dao.PhoneDao.add(phone);
        
        response.sendRedirect("Contacs");
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
