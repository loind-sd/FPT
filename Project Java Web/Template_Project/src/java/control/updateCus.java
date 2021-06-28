/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Customer;
import dao.DAO;
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
@WebServlet(name = "updateCus", urlPatterns = {"/updateCus"})
public class updateCus extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String rePass = request.getParameter("re_pass");
        System.out.println("alo " + rePass);

        HttpSession session = request.getSession();
        int id = ((Customer) session.getAttribute("customer")).getCusid();

        DAO dao = new DAO();

        if (rePass.trim().isEmpty()) {
            String passs = ((Customer) session.getAttribute("customer")).getPass();
            Customer c = new Customer(id, name, phone, address, user, passs);
            dao.updateCusNoChangePass(c);
            session.setAttribute("customer", c);
            request.setAttribute("h4", "Update Successful!");
        } else {
            if (!pass.equalsIgnoreCase(rePass)) {
                request.setAttribute("h4", "RePass is not correct!");
            } else {
                Customer c = new Customer(id, name, phone, address, user, pass);
                dao.updateCusWithChangePass(c);
                session.setAttribute("customer", c);
                request.setAttribute("h4", "Update Successful!");
            }
        }
        request.getRequestDispatcher("UserAccount.jsp").forward(request, response);

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
