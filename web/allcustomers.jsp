<%-- 
    Document   : allcustomer
    Created on : Mar 19, 2020, 11:57:36 PM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All customers</title>
    </head>
    <body>
        <table border="1">
            <th> Customer ID</th>
            <th>Customer email</th>
            <th>Address</th>
    <c:forEach items="${requestScopr.list}" var="customer">            
    <tr>
        <td><a href="./GetCustomer?id=${customer.customerID}">${customer.customerID}</a></td>
        <td>${customer.email}</td>
        <td>${customer.address}</td>
    </tr>
            </c:forEach>
        </table>
    </body>
</html>
