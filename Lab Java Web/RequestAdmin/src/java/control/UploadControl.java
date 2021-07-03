/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import dao.Request;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UploadControl", urlPatterns = {"/upload"})
public class UploadControl extends HttpServlet {

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

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);


        try {
            List<FileItem> fileItem = upload.parseRequest(request);
            for (FileItem file : fileItem) {
                if (!file.isFormField()) {
                    String name = file.getName();
                    if (!name.equals("")) {
                        String urlDir = request.getServletContext().getRealPath("")
                                + File.separator + "files";
                        File f = new File(urlDir);
                        if (!f.exists()) {
                            f.mkdir();
                        }

                        String urlFileUpload = urlDir + File.separator + name;
                        File fileUpload = new File(urlFileUpload);
                        try {
                            file.write(fileUpload);
                        } catch (Exception e) {
                            System.out.println("Upload File: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            System.out.println("FfileUpLoad: " + e.getMessage());
        }

        String id = request.getParameter("id");
        DAO dao = new DAO();
        Request r = dao.getRequestByID(id);
        request.setAttribute("r", r);
        request.setAttribute("hidden", 1);
        request.setAttribute("afterUpload", 1);
        request.getRequestDispatcher("SolveRequest.jsp").forward(request, response);
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
