/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.ejb.CustomerDAO;

/**
 *
 * @author pc
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {
     @EJB private CustomerDAO customerDAO;

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
        String customerID = request.getParameter("id");
        String email= request.getParameter("email");
        String address = request.getParameter("address");
        String operation = request.getParameter("operation");
        
        Customer customer = new Customer(customerID, email, address);
        
        if (operation.equalsIgnoreCase("add")) {
          customerDAO.addCustomer(customer);
            request.setAttribute("customer", customer);
        } else if (operation.equalsIgnoreCase("Edit")){
            customerDAO.editCustomer(customer);
            Customer searchedCustomer = customerDAO.getCustomer(customerID);
            request.setAttribute("customer", searchedCustomer);
        } else if (operation.equalsIgnoreCase("Delete")){
           customerDAO.deleteCustomer(customer);
        } else if (operation.equalsIgnoreCase("Search")){
            Customer searchedCustomer = customerDAO.getCustomer(customerID);
            request.setAttribute("customer", searchedCustomer);
        }

        request.getRequestDispatcher("customer.jsp").forward(request, response);

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
