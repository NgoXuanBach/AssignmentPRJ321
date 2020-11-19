

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm</title>
        <style type="text/css">
            heade   r {
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

                background-image:url(images/dep2.png);

            }
        </style>
    </head>
    <body class="hehe">
        <c:if test="${not empty sessionScope.orderid}">
        <center>
            <form action="process" method="POST">
                <h1 class="huhu" style="font-family: cursive"><font color="red">Thanks,${sessionScope.fn}</font></h1><br/>
                <h2 class="huhu" style="font-family: cursive;color: orangered;height: 28px;text-align: center"> >.< YOUR ORDER <u>${sessionScope.orderid}</u> IS GENERATED>.< </h2><br/>
                <input  style="font-family: cursive" class="haha" type="submit" name="bt" value="Buy More Product"/><br/>
                <br/>
                <input style="font-family: cursive" class="haha" type="submit" name="btAction" value="View History"/><br/>
            </form>
        </center>
        </c:if>
        
    </body>
</html>
