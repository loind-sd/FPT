/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import dao.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addToCard", urlPatterns = {"/addToCard"})
public class addToCard extends HttpServlet {

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
        HttpSession session = request.getSession();
        String id = request.getParameter("id"); // id - key

        int number = Integer.parseInt(session.getAttribute("numberProduct").toString());

        Product pro = (Product) session.getAttribute(id);
        DAO dao = new DAO();

        int quantityNow = dao.getProduct(id).getQuantity();

        if (pro == null) {
            pro = dao.getProduct(id);
            pro.setQuantity(1);
            session.setAttribute(id, pro);
            session.setAttribute("in4Add", "");
            number++;
        } else if (pro.getQuantity() == quantityNow) {
            System.out.println("bang r ne");
            session.setAttribute("in4Add", "Hiện tại cửa hàng không còn đủ sản phẩm " + pro.getName() +". Mong quý khách thông cảm!");
        } else {
            pro.setQuantity(pro.getQuantity() + 1);
            session.setAttribute(id, pro);
            session.setAttribute("in4Add", "");
            number++;
        }

        session.setAttribute("pid", id);
        session.setAttribute("numberProduct", number);
        response.sendRedirect("home");
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
