/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.PhoneType;

/**
 *
 * @author user
 */
@WebServlet(name = "AddPhone", urlPatterns = {"/AddPhone"})
public class AddPhone extends HttpServlet {



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
        int costumerId = Integer.parseInt(request.getParameter("costumerId"));
        String costumerName = request.getParameter("costumerName");        
        List <PhoneType> list;
        list = dao.PhoneTypeDao.phoneTypeList();        
        request.setAttribute("list", list);
        request.setAttribute("costumerId", costumerId);
        request.setAttribute("costumerName", costumerName);
        request.getRequestDispatcher("addNumber.jsp").forward(request, response);        
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
