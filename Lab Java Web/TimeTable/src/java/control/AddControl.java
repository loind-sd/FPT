/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import validate.Validation;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {

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
        
        String date = request.getParameter("date");
        String slot = request.getParameter("slot");
        String room = request.getParameter("room");
        String teacher = request.getParameter("teacher");
        String classID = request.getParameter("class");
        String result = "Add Successful!";
        
        DAO dao = new DAO();
        Validation v = new Validation();
        
        int teacherID = dao.checkTeacherExist(teacher);
        
        if (!v.checkDateValid(date)) {
            result = "Date is not valid!";
        }
        else if (teacherID == -1) {
            result = "Teacher don't exist!";
        } 
        else if (dao.checkRoomExist(date, Integer.parseInt(slot), Integer.parseInt(room))) {
            result = "FAIL!!! This Room have class in this time!";
        } 
        else if (dao.checkTeacherHaveClass(date, Integer.parseInt(slot), teacherID)) {
            result = "FAIL!!! Teacher " + teacher + " have class in this time!";
        } 
        else {
            if (dao.addTimeTable(
                    Integer.parseInt(classID),
                    date,
                    Integer.parseInt(slot),
                    Integer.parseInt(room),
                    teacherID) == 1) {
                request.setAttribute("result", result);
                request.getRequestDispatcher("home").forward(request, response);
                return;
            }
            result = "This class is learning in this time!";
        }
        request.setAttribute("slot", slot);
        request.setAttribute("date", date);
        request.setAttribute("room", room);
        request.setAttribute("teacher", teacher);
        request.setAttribute("class", classID);
        request.setAttribute("result", result);
        request.getRequestDispatcher("Add.jsp").forward(request, response);
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
