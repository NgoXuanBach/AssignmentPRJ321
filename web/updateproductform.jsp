

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>
        <p><a href="process?btAction=Manage Products">Back</a></p>
        <center>
        <h1>Update Product Form</h1>
        <p><i>You need fill up following to update.</i></p>
        <form action="process" method="POST">
            <table>
                <c:set var="err" value="${requestScope.ERRORS}"/>
                <c:set var="p" value="${sessionScope.ProductUp}"/>
                    <tr>
                        <td>ID: </td>
                        <td>${p.id}</td>
                    </tr>
                
                    <tr>
                        <td>Name: </td>
                        <td><input type="txt" name="productname" value="${p.name}"/>(2-20 chars)</td>
                    </tr>    
                
                <c:if test="${not empty err.nameerr}">
                    <tr>
                        <td><font color="red">${err.nameerr}</font></td>
                    </tr>
                    
                </c:if>
                    <tr>
                        <td>Price: </td>
                        <td><input type="text" name="productprice" value="${p.price}"/></td>
                    </tr>   
               
                <c:if test="${not empty err.priceerr}">
                    <tr>
                        <td> <font color="red">${err.priceerr}</font></td>
                    </tr>
                   
                </c:if>
                    <tr>
                        <td>Img URL: </td>
                        <td><input type="text" name="productimg" value="${p.img}"/></td>
                    </tr>   
                
                <c:if test="${not empty err.imgerr}">
                    <tr>
                        <td><font color="red">${err.imgerr}</font></td>
                    </tr>
                    
                </c:if>
                    <tr>
                        <td>Category: </td>
                        <td>
                            <select name="categories">
                                <c:if test="${not empty sessionScope.category}">
                                    <c:forEach var="c" items="${sessionScope.category}">
                                        <option>${c.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                    <input type="hidden" name="productid" value="${p.id}"/>
                    <input type="hidden" name="delete" value="${p.isdelete}">
                 </table>
                    <br/>
                    <input type="submit" value="Update" name="btAction" />
                    
        </form>
        </center>        
    </body>
</html>
