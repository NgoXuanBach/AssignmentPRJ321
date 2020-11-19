/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletcontrol;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "ProcessServlet", urlPatterns = {"/ProcessServlet"})
public class ProcessServlet extends HttpServlet {
    private final String loginpage="login.jsp";
    private final String nullServlet = "NullServlet";
    private final String loginServlet = "loginServlet";
    private final String logoutServlet = "logoutServlet";
    private final String registerform = "registerform.jsp";
    private final String registerServlet = "RegisterServlet";
    private final String buyServlet = "buyServlet";
    private final String viewCart = "viewcart.jsp";
    private final String removeServlet = "RemoveServlet";
    private final String confirmServlet = "ConfirmServlet";
    private final String searchServlet = "SearchServlet";
    private final String historyServlet = "HistoryServlet";
    private final String detailServlet = "DetailServlet";
    private final String manageproduct = "manageproduct.jsp";
    private final String addproductform = "addproductform.jsp";
    private final String addproductServlet = "AddProductServlet";
    private final String updateproduct = "updateproductform.jsp";
    private final String updateproductServlet = "updateproductServlet";
    private final String deleteproductServlet = "DeleteProductServlet";
    private final String searchforadminServlet = "SearchForAdminServlet";
    private final String manageuser = "manageuser.jsp";
    private final String deleteuserServlet = "DeleteUserServlet";
    private final String searchaccountServlet = "SearchAccountServlet";
    private final String vieworderServlet = "ViewOrderServlet";
    private final String viewdetailServlet = "ViewDetailServlet";
    private final String viewallorder = "viewallorder.jsp";
    private final String getcategoryServlet = "GetCategoryServlet";
    private final String getcategoryServlet2 ="GetCategoryServlet2";
    private final String addcategoryform = "addcategoryform.jsp";
    private final String addcategoryServlet = "AddCategoryServlet";
   

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
        HttpSession ss = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("btAction");
            String url=loginpage;
            if(null == action){
                url=nullServlet;
            }
            else switch (action) {
                case "Login":
                    url=loginServlet;
                    break;
                case "Logout":
                    url=logoutServlet;
                    break;
                case "Register":
                    url=registerform;
                    break;
                case "Register Account":
                    url=registerServlet;
                    break;
                case "Buy":
                    url=buyServlet;
                    break;
                case "View Your Cart":
                    url=viewCart;
                    break;
                case "Remove":
                    url=removeServlet;
                    break;
                case "Confirm To Order":
                    url=confirmServlet;
                    break;
                case "Search":
                    url=searchServlet;
                    break;
                case "View History":
                    url=historyServlet;
                    break;
                case "Details":
                    url=detailServlet;
                    break;
                case "Manage Products":
                    ss.setAttribute("listproduct", ProductDAO.getAllProductForAdmin());
                    ss.setAttribute("category", CategoryDAO.getAllCategory());
                    url=manageproduct;
                    break;
                case "Add New Product":
                    url=addproductform;
                    break;
                case "Add":
                    url=addproductServlet;
                    break;
                case "Update Product":
                    String id = request.getParameter("id").trim();
                    ss.setAttribute("ProductUp", ProductDAO.getProductById(id));
                    url=updateproduct;
                    break;
                case "Update":
                    url=updateproductServlet;
                    break;
                case "Delete Product":
                    url=deleteproductServlet;
                    break;
                case "Search Name":
                    url=searchforadminServlet;
                    break;
                case "Manage Users":
                    ss.setAttribute("listaccount", AccountDAO.getAllAccount(0));
                    url=manageuser;
                    break;
                case "Delete Account":
                    url=deleteuserServlet;
                    break;
                case "Search Username":
                    url=searchaccountServlet;
                    break;
                case "View Order":
                    url=vieworderServlet;
                    break;
                case "View Details":
                    url=viewdetailServlet;
                    break;
                case "View All Order":
                    request.setAttribute("allorder", OrderDAO.getAllOrder());
                    url=viewallorder;
                    break;
                case "Get Category":
                    url=getcategoryServlet;
                    break;
                case "Get Category2":
                    url=getcategoryServlet2;
                    break;
                case "Add New Category":
                    url=addcategoryform;
                    break;
                case "Add Category":
                    url=addcategoryServlet;
                    break;
                default:
                    break;
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
