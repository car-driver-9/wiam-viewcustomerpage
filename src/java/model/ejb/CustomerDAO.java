/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;
import model.Customer;
/**
 *
 * @author pc
 */
@Stateless
@LocalBean
public class CustomerDAO {

    public static void editcustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Resource (name="jdbc/customerDB")
    private DataSource ds;
    private Customer customer;

    public CustomerDAO() {
        this.Customer = customer;
    }
     public void addCustomer(Customer customer) {
         String sql ="INSERT INTO CUSTOMER VALUES('"+customer.getCustomerID()+"', '"+customer.getEmail()+"','"+customer.getAddress()+"')";
         executeModifyQuery(sql);
     }
    public void editCustomer(Customer customer) {
         String sql ="UPDATE CUSTOMER SET NAME='"+customer.getCustomerID()+"', '"+customer.getEmail()+"','"+customer.getAddress()+"'";
         executeModifyQuery(sql);
    }
    public void deleteCustomer(Customer customer) {
         String sql ="DELETE FROM CUSTOMER WHERE CUSTOMERID='"+customer.getCustomerID()+"'";
         executeModifyQuery(sql);
    }
      public Customer getCustomer(String id) {
         Customer customer = new Customer() ;
         String sql ="SELECT * FROM CUSTOMER WHERE CUSTOMERID='"+id+"'";
         System.out.println(sql);
         ResultSet rs = executeFetchQuery(sql); 
         try{
             if(rs.next()){
                 customer.setCustomerID(rs.getString("CUSTOMERID"));
                 customer.setEmail(rs.getString("EMAIL"));
                 customer.setAddress(rs.getString("ADDRESS"));


         }
                 
             }catch (SQLException ex){
                 System.err.println("65" + ex.getMessage());
         }
            return customer;
         
      }
    private final Customer Customer;
      public ArryList<Customer> getAllCustomer() {
          ArryList<Customer> list = new ArryList<>();
          String sql="SELECT* FROM CUSTOMER";
          ResultSet rs = executeFetchQuery(sql);
      try{
          while(rs.next()){
              Customer customer = new customer();
              customer.setCustomerID("CUSTOMERID");
              customer.setEmail("EMAIL");
              customer.setAddress("ADDRESS");
              list.add(customer);
          }
      }catch (SQLException ex) {
                 System.err.println( ex.getMessage());
      }
      return list;
      }     
    public void executeModifyQuery(String sql){
        try {
            try (Connection conn = ds.getConnection()) {
                conn.createStatement().execute(sql);
            }
            
            
        }catch (SQLException e){
        System.err.println(e.getMessage());
    }
    }
     public ResultSet executeFetchQuery(String sql){
         ResultSet rs = null;
        try {
             try (Connection conn = ds.getConnection()) {
                 conn.createStatement().executeQuery(sql);
             }
            
            
        }catch (SQLException e){
        System.err.println(e.getMessage());
    }
        return rs;
    }
}




