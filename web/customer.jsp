<%-- 
    Document   : index
    Created on : Mar 19, 2020, 11:13:15 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer list</title>
    </head>
    <body>
        <table bored="1">
            <td><a href="customer.jsp">Customer info</a></td>
            <td><a href="./Allcustomer">All Customer</a></td>
        </table>
        <br />
        
       <form action="./CustomerServlet" method="POST">
           <table>
               <tr>
                   <td>Customer ID</td> 
                   <td><input type="text" name="id" value="${customer.customerID}"/></td>
               </tr> 
               <tr>
                   <td>Email</td> 
                   <td><input type="text" name="email" value="${customer.email}"/></td>
               </tr>
               <tr>
                   <td>Address</td> 
                   <td><input type="text" name="address" value="${customer.address}"/></td>
               </tr>
               <tr>
                   <td colspan="2"><input type="Submit" name="operation" value="Add" />
                   <input type="Submit" name="operation" value="Edit" />
                     <input type="Submit" name="operation" value="Delete" />
                     <input type="Submit" name="operation" value="Search" /></td>
               </tr>
               
               
           </table>
            
            
   
        </form>

    </body>
</html>
