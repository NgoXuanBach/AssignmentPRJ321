/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.OrderDAO;
import dao.OrderLineDAO;
import dto.Order;
import dto.OrderLine;
import dto.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
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
@WebServlet(name = "ConfirmServlet", urlPatterns = {"/ConfirmServlet"})
public class ConfirmServlet extends HttpServlet {
    private final String confirmview = "confirmview.jsp";

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
        Random r= new Random();
        int orderid=0;
        try (PrintWriter out = response.getWriter()) {
            do{
                orderid = r.nextInt((100000 - 1000) + 1) + 1000;
            }while(OrderDAO.getOrderById("OD"+orderid) != null);
            
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date d = new Date();
            String date = df.format(d);///
            
            HttpSession s = request.getSession();
            
            String username = (String) s.getAttribute("us");
            double total = Double.parseDouble(s.getAttribute("total").toString());
            int res1 = OrderDAO.createOrder(new Order("OD"+orderid, date, total, username));
            
            int res2 =0;
            ArrayList<ShoppingCart> list = (ArrayList<ShoppingCart>) s.getAttribute("cart");
            for (ShoppingCart sc : list) {
                res2 = OrderLineDAO.createOrderLine(new OrderLine("OD"+orderid, 
                        sc.getPd().getId(),sc.getPd().getName(),sc.getPd().getPrice() ,sc.getQuantity(),
                                    sc.getPd().getPrice()*sc.getQuantity()));
            }
            if(res1>0 && res2>0){
                s.setAttribute("orderid", "OD"+orderid);
                s.removeAttribute("cart");
                response.sendRedirect(confirmview);
            }
            
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
