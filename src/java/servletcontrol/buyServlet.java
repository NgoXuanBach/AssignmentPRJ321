/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.ProductDAO;
import dto.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "buyServlet", urlPatterns = {"/buyServlet"})
public class buyServlet extends HttpServlet {
    private final String processServlet="process";
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
            HttpSession s = request.getSession();
            String id = request.getParameter("id");
            if (s.getAttribute("cart") == null) {
                ArrayList<ShoppingCart> listcart = new ArrayList<>();
                //String id = request.getParameter("id");
                listcart.add(new ShoppingCart(ProductDAO.getProductById(id), 1));
                s.setAttribute("cart", listcart);
            }
            else{
                ArrayList<ShoppingCart> listcart = (ArrayList<ShoppingCart>) s.getAttribute("cart");
                //String id = request.getParameter("id");
                int index = ShoppingCart.isExist(id, listcart);
                if(index<0){
                    listcart.add(new ShoppingCart(ProductDAO.getProductById(id), 1));
                }
                else{
                    int quantity=listcart.get(index).getQuantity()+1;
                    listcart.get(index).setQuantity(quantity);
                }
                s.setAttribute("cart", listcart);
            }
            response.sendRedirect(processServlet);
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
