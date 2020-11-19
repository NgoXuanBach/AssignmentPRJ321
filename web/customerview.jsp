
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style type="text/css">
            header {
                height: 200px;
                align-items: center;
            }
            section {
            }
            .img{
                text-align: center;
                border: 1.5px solid #17a2b8;
                padding:auto;
                margin: 5px;
                height : 300px;
                width: 358px;
                float:left;
                font-family: cursive;
                font-size: 22px;
                background-image: inherit;
                color: #000;
                background-color: white;




            }
            footer {
                clear: both;
                height: 200px;
                align-items: center;
            }

            .huhu:hover
            {
                color: #17a2b8;


            }
            footer {
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

                background-image:url(https://wallpapershome.com/images/pages/pic_h/17423.jpg);
            }
        </style>

    </head>
    <body class="hehe">
     
    <center >
        <!--        <img alt=""src="images/logo-nuoc-ep-5.png">-->
        <h3><font style="font-family: cursive;font-size:33px"color="black">Welcome, ${sessionScope.fn}</font></h3>
        <form action="process" method="POST">
            <input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px" class="btn-primary"style="width:60px;height: 25px;background: #ccffff" type="submit" value="Logout" name="btAction" onclick="return confirm('Are you sure to Logout ?')"/>
            <input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px" class="btn-primary"style="width:60px;height: 25px;background: #ccffff" type="submit" name="bt" value="Home"/>
            <input  style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px" class="btn-primary" style="width:90px;height: 25px;background: #ccffff"type="submit" name="btAction" value="View History"/>

        </form>

        <c:if test="${empty orderlist}">
            <form action="process" method="POST">
                <table>
                    <tr>
                        <td><input  style="width:268px;height:30px;margin: -45px;font-family: cursive"placeholder="Enter Name Product"type="text" name="searchValue" value="${param.searchValue}"/></td>
                        <td><input style="font-family: cursive;margin:13px;margin-right: -57px "type="submit" name="btAction" value="Search"/></td>
                    </tr>
                </table>
            </form>
            <%--listsearch    --%>            
            <c:if test="${not empty listsearch}">
                <br/>
                <table class=" table-bordered table-hover"width="30%" border="1" style="background-color: aliceblue;font-family: cursive;font-size: 16px">
                    <thead>
                        <tr>
                            <th  style="font-family: cursive">ID</th>
                            <th  style="font-family: cursive">Name</th>
                            <th  style="font-family: cursive">Price</th>
                            <th  style="font-family: cursive">Image</th>
                            <th  style="font-family: cursive">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${listsearch}">
                            <tr>
                                <td style="font-family: cursive">${product.id}</td>
                                <td style="font-family: cursive">${product.name}</td>
                                <td style="font-family: cursive">${product.price}VNĐ</td>
                                <td style="font-family: cursive;background-color:  white;text-align: center"><img
                                        src="${product.img}" width="120px"></td> 
                                <td class="haha"align="center"><a href="process?btAction=Buy&id=${product.id}">Buy</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${not empty value}">     
                <c:if test="${empty listsearch}">
                    <p><font color="red">No result of '${value}'</font></p>
                    </c:if>
                </c:if>
                <%--category    --%>  
                <c:if test="${not empty sessionScope.category}">
                <br/>    
                <table class="table-bordered table-hover" style="background-color: mistyrose;font-family: serif;font-size: 16px;border : 2px solid #17a2b8">
                    <tr>
                        <c:forEach var="c" items="${sessionScope.category}">
                            <td><a class="haha "href="process?btAction=Get Category&id=${c.name}">${c.name}</a></td>
                            </c:forEach>
                    </tr>
                </table>
            </c:if> 
            <c:if test="${not empty productcategory}">
                <p class="huhu" style="color: navy">_${name}_</p>
                <table class=" table-bordered table-hover"width="50%" border="1px solid #17a2b8" style="background-color: snow">
                    <thead>
                        <tr>
                            <th style="font-family: cursive">ID</th>
                            <th style="font-family: cursive">Name</th>
                            <th style="font-family: cursive">Price</th>
                            <th style="font-family: cursive">Image</th>
                            <th style="font-family: cursive">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productcategory}">

                            <tr>

                                <td style="font-family: cursive">${product.id}</td>
                                <td style="font-family:  cursive">${product.name}</td>
                                <td style="font-family: cursive">${product.price}VNĐ</td>
                                <td style="background-color: white;text-align: center"><img 
                                        src="${product.img}" width="120"> </td>
                                <td style="font-family: cursive"class="haha"align="center"><a href="process?btAction=Buy&id=${product.id}">Buy</a></td>

                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty productcategory}">
                <p><font color="grey">${name}</font></p>
                </c:if>
                <%--listproduct    --%>   
            <p><font color="orange">------------------------------------</font></p>   
            <h2><font style="font-family: cursive"color="black" > List All Of Product </font></h2><br/>

            <form action="process" method="POST">

                <input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px" class="btn-primary"style="width:60px;height: 25px;background: #ccffff"class="haha"style="background: #ccffff;width: 140px;height: 26px;font-family: cursive"type="submit" value="View Your Cart" name="btAction"/> 
                <c:if test="${not empty sessionScope.listproduct}">
                    <section>
                        <c:forEach var="product" items="${sessionScope.listproduct }">
                            <div class="img">
                                ${product.id } - ${product.name } <br> 
                                <img style="width: 250px ;height: 150px"
                                     src="${product.img}"> 
                                <br> 
                                ${product.price} VNĐ<br>
                                <a  style="background-color: forestgreen"class="btn-primary"href="process?btAction=Buy&id=${product.id }">Buy</a>
                            </div>
                        </c:forEach>

                    </section>
                </c:if>

            </form>

        </c:if>
        <%--orderlist    --%>
        <c:if test="${not empty orderlist}">
            <h2 style="font-family: cursive; margin:revert">Your History</h2>
            <table class=" table table-bordered table-hover" style="background-color: whitesmoke">
                <thead>
                    <tr>
                        <th style="font-family: cursive">Time Order</th>
                        <th style="font-family: cursive">Order Id</th>
                        <th style="font-family: cursive">Total</th>
                        <th style="font-family: cursive">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orderlist}">
                        <tr>
                            <td style="font-family: cursive">${order.date}</td>
                            <td style="font-family: cursive">${order.orderid}</td>
                            <td style="font-family: cursive">${order.total}VNĐ</td>
                            <td style="font-family: cursive" class="haha"align="center"><a href="process?btAction=Details&id=${order.orderid}">View Details</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <%--detail    --%>    
        <c:if test="${not empty detail}">

            <h3 class="huhu"><font style="font-family: cursive" color="red"><i>OrderID: ${orderId}</i></font></h3>
            <table  style="background-color: #ccffff"class="table table-hover"width="50%" border="1">
                <thead>
                    <tr>
                        <th style="font-family: cursive">ProductID</th>
                        <th style="font-family: cursive">Product Name</th>
                        <th style="font-family: cursive">Unit Price</th>
                        <th style="font-family: cursive">Quantity</th>
                        <th style="font-family: cursive">Total Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ol" items="${detail}">
                        <tr>
                            <td style="font-family: cursive">${ol.productid}</td>
                            <td style="font-family: cursive">${ol.productname}</td>
                            <td style="font-family: cursive">${ol.unitprice}VNĐ</td>
                            <td style="font-family: cursive">${ol.quantity}</td>
                            <td style="font-family: cursive">${ol.totalprice}VNĐ</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </center>

</body>
</html>

