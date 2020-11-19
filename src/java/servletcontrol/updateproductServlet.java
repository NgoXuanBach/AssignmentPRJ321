/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.ProductDAO;
import dto.AddProductErr;
import dto.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "updateproductServlet", urlPatterns = {"/updateproductServlet"})
public class updateproductServlet extends HttpServlet {
    private final String error = "updateproductform.jsp";

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
            String id = request.getParameter("productid").trim();
            String name = request.getParameter("productname").trim();
            String price = request.getParameter("productprice").trim();
            String img = request.getParameter("productimg").trim();
            String isdelete = request.getParameter("delete").trim();
            String category = request.getParameter("categories").trim();
            
            boolean err = false;
            AddProductErr ape = new AddProductErr();
            
            if(name.length()<2 || name.length()>20){
                err=true;
                ape.setNameerr("Name's length is 5--20");
            }
            
            if(!price.matches("^[0-9]+(\\.[0-9]){0,1}$")){
                err=true;
                ape.setPriceerr("Price must be number");
            }
            
            request.setAttribute("ERRORS", ape);
            String url = error;
            if(err==false){
                Product p = new Product(id, name, Double.parseDouble(price), img, 
                        Integer.parseInt(isdelete), category);
                int res = ProductDAO.updateProduct(p);
                if(res>0){
                    url="ProcessServlet?btAction=Manage Products";
                }
            }
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
