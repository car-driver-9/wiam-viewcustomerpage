/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pc
 */
public class Customer {
    private String customerID;
    private String email;
    private String address;
    
  public String getAddress() {
      return address;
  }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
      return email;
  }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCustomerID() {
      return customerID;
  }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public Customer(String customerID, String email, String address) {
        this.customerID = customerID;
        this.email = email;
        this.address = address;
        
    }
    public Customer(){}
}
