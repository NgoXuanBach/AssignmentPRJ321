/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.AccountDAO;
import dto.Account;
import dto.RegisterErr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private final String error="registerform.jsp";
    private final String loginPage="login.jsp";

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
            String username = request.getParameter("txtUn").trim();
            String password = request.getParameter("txtPw").trim();
            String confirm = request.getParameter("txtConfirm").trim();
            String fullname = request.getParameter("txtFullname").trim();
            
            boolean errs = false;
            RegisterErr rErr= new RegisterErr();
            if(username.length()<6 || username.length()>20){
                errs=true;
                rErr.setUsernameErr("Username's length must be 6 --> 20 characters.");
            }
            else if(AccountDAO.getAccountByUn(username)!=null){
                errs=true;
                rErr.setUsernameErr("Username: "+username+" was existed.");
            }
            if(password.length()<6 || password.length()>20){
                errs=true;
                rErr.setPasswordErr("Password's length must be 6 --> 20 characters.");
            }
            else if(!confirm.equals(password)){
                errs=true;
                rErr.setConfirmErr("Password not matched.");
            }
            if(!fullname.matches("^[a-zA-Z ]+$")){
                errs=true;
                rErr.setFullnameErr("Fullname must be only letters.");
            }
            else if(fullname.length()<5 || fullname.length()>50){
                errs=true;
                rErr.setFullnameErr("Fullname's length must be 5 --> 20 letters.");
            }
            
            request.setAttribute("ERRORS", rErr);
            String url = error;
            if(errs==false){
                Account a = new Account(username, password, fullname, 0,0);
                int res = AccountDAO.createAccount(a);
                if(res>0){
                    url=loginPage;
                }
                else{
                    rErr.setDuplicateUsername(username+" was existed.");
                    request.setAttribute("ERRORS", rErr);
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
