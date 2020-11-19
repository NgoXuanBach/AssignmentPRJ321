

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <style type="text/css">
            header {
                height: 200px;
                align-items: center;
            }
            section {
            }
            .img {
                text-align: center;
                border: 1px solid #17a2b8;
                padding:auto;
                margin: 5px;
                height : 300px;
                width: 362px;
                float:left;
                font-family: cursive;
                font-size: 22px;
                background-image: image;


            }footer {
                clear: both;
                height: 200px;
                align-items: center;
            }

            .huhu:hover
            {
                color: #17a2b8;


            }.haha:hover
            {
                color: #17a2b8;
                border: 1px solid;
                background: #ccffff;
                text-align: center;

            }
            .hihi:hover
            {
                color: #1da1f2;
                font-family: cursive;
                font-size: 10px;
                background: radial-gradient;
                border: 1px appworkspace;


            }
            .hehe
            {
                background-image:url(https://wallpapershome.com/images/pages/pic_h/12576.jpg);
            }
        </style>
    </head>
    <body class="hehe">
        <p><a style="font-family: cursive;font-size: 20px
              " class="btn-primary" class="haha"href="process?btAction=Manage Users">BACK</a></p>
        <img alt="" src="images/admin.png">
    <center>
        <h2 style=" font-family: cursive;font-size: 50px;color: white">Order of username: '${sessionScope.username}'</h2>
        <c:if test="${not empty sessionScope.orderlist}">
            
            <table style="background-color: cornsilk"class=" table-bordered table-hover"width="100%" border="1px solid #17a2b8">
                <thead>
                    <tr>
                        <th  style="font-family: cursive">Number</th>
                        <th  style="font-family: cursive">Time</th>
                        <th  style="font-family: cursive"> Order Id</th>
                        <th  style="font-family: cursive">Total</th>
                        <th  style="font-family: cursive">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0"/>
                    <c:set var="tong" value="0"/>
                    <c:forEach var="order" items="${sessionScope.orderlist}">
                        <c:set var="count" value="${count+1}"/>
                        <c:set var="tong" value="${tong + order.total}"/>
                        <tr>
                            <td style="font-family: cursive">${count}</td>
                            <td style="font-family: cursive">${order.date}</td>
                            <td style="font-family: cursive">${order.orderid}</td>
                            <td style="font-family: cursive">${order.total}VNĐ</td>
                            <td  style="font-family: cursive"align="center"><a href="process?btAction=View Details&id=${order.orderid}">View Details</a></td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
                    <p><font style="font-size: 35px"color="red"><b class="huhu">Total used: ${tong}VNĐ</b></font></p>       
            </c:if>    
            <c:if test="${empty sessionScope.orderlist}">
            <p><font style="font-family: cursive;font-size: 28px"class="huhu" color="red"> Not yet buy anything</font></p>    
            </c:if>  


        <c:if test="${not empty listdetail}">
            <h2><font color="black"><u>${orderid}</u></font></h2>
            <table style="background-color: cornsilk"class=" table-bordered table-hover"width="75%" border="1px solid #17a2b8">
                <thead>
                    <tr>
                        <th style="font-family: cursive">Number</th>
                        <th style="font-family: cursive">Product Id</th>
                        <th style="font-family: cursive">Product Name</th>
                        <th style="font-family: cursive">Unit Price</th>
                        <th style="font-family: cursive">Quantity</th>
                        <th style="font-family: cursive">Total Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0"/>

                    <c:forEach var="order" items="${listdetail}">
                        <c:set var="count" value="${count+1}"/>

                        <tr>
                            <td style="font-family: cursive">${count}</td>
                            <td style="font-family: cursive">${order.productid}</td>
                            <td style="font-family: cursive">${order.productname}</td>
                            <td style="font-family: cursive">${order.unitprice}VNĐ</td>
                            <td style="font-family: cursive">${order.quantity}</td>
                            <td style="font-family: cursive">${order.totalprice}VNĐ</td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>   
        </c:if>    



    </center>  
  
</body>
</html>
