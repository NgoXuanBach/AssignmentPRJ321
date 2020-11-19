
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
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
    <center>
        <h3 style="font-family: cursive;font-size: 40px;color: magenta"><font >Welcome, ${sessionScope.fn}</font></h3>
        <form action="process" method="POST">
            <input style="font-family: cursive;font-size: 20px"class="haha" type="submit" value="Logout" name="btAction" onclick="return confirm('Are you sure to Logout ?')"/>
            <input style="font-family: cursive;font-size: 20px" class="haha" type="submit" name="bt" value="Home"/>
            <input style="font-family: cursive;font-size: 20px" class="haha" type="submit" name="btAction" value="View History"/>
        </form>
    </center>
    <center> 
        <h1 style="font-family: cursive;margin: revert;font-size: 50px"><font color="black" class="huhu" >Your Shopping Cart</font></h1>
        <form action="process" method="POST">


            <c:if test="${not empty sessionScope.cart}">
                <table  class="table table-hover"style="background-color: aliceblue">
                    <thead>
                        <tr>
                            <th style="font-family: cursive">ID</th>
                            <th style="font-family: cursive">Name</th>
                            <th style="font-family: cursive">Price/per 1</th>
                            <th style="font-family: cursive">Quantity</th>
                            <th style="font-family: cursive">Price/Quantity</th>
                            <th style="font-family: cursive">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="0" scope="session"></c:set>
                        <c:forEach var="item" items="${sessionScope.cart}">
                            <c:set var="total" value="${total + item.pd.price*item.quantity}" scope="session"></c:set>

                                <tr>

                                    <td>${item.pd.id}</td>
                                <td style="font-family: cursive">${item.pd.name}</td>
                                <td style="font-family: cursive">${item.pd.price}VNĐ</td>
                                <td style="font-family: cursive">${item.quantity}</td>
                                <td style="font-family: cursive">${item.pd.price*item.quantity}VNĐ</td>
                                <td style="font-family: cursive;color: #17a2b8" class="haha"align="center"><a href="process?btAction=Remove&id=${item.pd.id}"
                                                                                                              onclick="return confirm('Are you sure to remove this item ?')">Remove</a></td>

                            </tr>

                        </c:forEach>
                    </tbody>
                    <tr>
                        <td style="font-family: cursive" colspan="5" align="right"><b>Total: </b></td>
                        <td  style="font-family: cursive" align="center">${total}VNĐ</td>
                    </tr>
                </table>
                <br/><input style="font-family: cursive" class="haha" type="submit" value="Confirm To Order" name="btAction"
                            onclick="return confirm('Are you sure to Confirm ?')"/>
            </c:if>
            <br/>    
            <br/><input style="font-family: cursive;font-size: 20px" class="haha"type="submit" value="Buy More Product" name="bt"/>
        </form>
    </center>
</body>
</html>
