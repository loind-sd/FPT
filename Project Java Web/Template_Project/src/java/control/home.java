/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Category;
import dao.DAO;
import dao.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        //
        HttpSession session = request.getSession();
        int number;
        try {
            String value = session.getAttribute("numberProduct").toString();
        } catch (NullPointerException e) {
            number = 0;
            session.setAttribute("numberProduct", number);
        }
        try {
            String value = session.getAttribute("isLogin").toString();
        } catch (NullPointerException e) {
            number = 0;
            session.setAttribute("isLogin", number);
        }
        try {
            String value = session.getAttribute("isAdmin").toString();
        } catch (NullPointerException e) {
            number = 0;
            session.setAttribute("isAdmin", number);
        }
        //

        DAO dao = new DAO();
        int num = dao.getNumberProduct();
        int pageSize = 6;
        int end = num / pageSize;
        if (num % pageSize != 0) {
            end++;
        }

        int index = 1;
        try {
            index = Integer.parseInt(request.getParameter("index"));
        } catch (Exception e) {
        }

        List<Product> list = dao.getAllProductUntil6(index, pageSize);
        List<Category> listCate = dao.getAllCAtegory();
//        Product max = dao.getProductMaxPrice();

//        request.setAttribute("max", max);
        

        request.setAttribute("end", end);
        request.setAttribute("action", 1);
        request.setAttribute("in", index);
        session.setAttribute("list", list);
        session.setAttribute("infor", "");
        request.setAttribute("listC", listCate);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
