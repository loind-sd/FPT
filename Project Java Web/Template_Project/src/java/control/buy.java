/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Bil;
import dao.BillDetail;
import dao.DAO;
import dao.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "buy", urlPatterns = {"/buy"})
public class buy extends HttpServlet {

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
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        HttpSession session = request.getSession();

        Date d = (Date) java.util.Calendar.getInstance().getTime();
        String date = sdf.format(d);
        
        String recName = request.getParameter("recName");
        String recAddress = request.getParameter("recAddress");
        String recPhone = request.getParameter("recPhone");
        
        int cid = Integer.parseInt(session.getAttribute("isLogin").toString());
        String total =session.getAttribute("allTotal").toString().replaceAll(",", "");
        
        DAO dao = new DAO();
        
        dao.addBill(new Bil(0, date, total, recName, recAddress, recPhone, cid, 0));
        
        //BillDetail và updateProductAfterBill 
        List<Product> list = (List<Product>) session.getAttribute("listInBill");
        int bid = dao.getFinalBillId();
        for (Product o : list) {
            String id = String.valueOf(o.getId());
            Product pro = (Product) session.getAttribute(id);
            String price = pro.getPrice().replaceAll(",", "");
            int quanity = pro.getQuantity();
            dao.addBillDetail(new BillDetail(bid, Integer.parseInt(id), price, quanity));
            

        }
        
        session.removeAttribute("listInBill");
        session.removeAttribute("allTotal");
        session.removeAttribute("numberProduct");
        
        request.setAttribute("afterBuy", 1);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
        
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
