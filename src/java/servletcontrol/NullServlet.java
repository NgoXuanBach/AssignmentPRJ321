/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import dto.Account;
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
 * @author DELL
 */
@WebServlet(name = "NullServlet", urlPatterns = {"/NullServlet"})
public class NullServlet extends HttpServlet {
    private final String loginPage="login.jsp";
    private final String adminview="adminview.jsp";
    private final String customerview="customerview.jsp";
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
        try (PrintWriter out = response.getWriter()) {
            String url=loginPage;
            HttpSession s = request.getSession();
            if(s.getAttribute("us")!=null && s.getAttribute("pw")!=null){
                String username = (String) s.getAttribute("us");
                String password = (String) s.getAttribute("pw");
                Account a= AccountDAO.getAccount(username, password);
                if (a != null) {
                    if (a.getIsdelete() == 0) {
                        if (a.getIsAdmin() == 1) {
                            s.setAttribute("listproduct", ProductDAO.getAllProductForAdmin());
                            
                            url = adminview;
                        } else {
                            s.setAttribute("listproduct", ProductDAO.getAllProduct());
                            s.setAttribute("category", CategoryDAO.getAllCategory());
                            url = customerview;
                        }
                        //s.setAttribute("category", CategoryDAO.getAllCategory());
                    }
                }
            }
            //request.removeAttribute("err");
            request.getRequestDispatcher(url).forward(request, response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
