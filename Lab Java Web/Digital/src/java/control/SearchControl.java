/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import dao.Digital;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
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
      //  processRequest(request, response);
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
         response.setContentType("text/html;charset=UTF-8");
        String txtSearch = request.getParameter("txtSearch");
        
        DAO dao = new DAO();
        
        int pageSize = 3;
        int num = dao.getNumberDigitalByTitle(txtSearch);
        int end = num / pageSize;
        if (num % pageSize != 0) {
            end++;
        }
        
        int index = 1;
        try {
            index = Integer.parseInt(request.getParameter("index"));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("txt: " + txtSearch);
        System.out.println("index: " + index);
        
        
        Digital digital = dao.getNewDigital();
        Digital digitalRecent = dao.getMostRecentNews();
        List<Digital> list = dao.getTop5Digital();
        List<Digital> listSearch = dao.searchDigital(txtSearch, index, pageSize);
        
        request.setAttribute("digital", digital);
        request.setAttribute("recent", digitalRecent);
        request.setAttribute("txt", txtSearch);
        request.setAttribute("index", index);
        request.setAttribute("end", end);
        request.setAttribute("listTop5", list);
        request.setAttribute("listSearch", listSearch);
        request.getRequestDispatcher("SearchResultPage.jsp").forward(request, response);
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
