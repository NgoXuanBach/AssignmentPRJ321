<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        
        <style type="text/css">


            .hehe
            {
                background-image:url(https://wallpapershome.com/images/pages/pic_h/12576.jpg);
            }


        </style>
    </head>
    <body class="hehe">


    <center>
        <h1 style="font-family: cursive;font-size: 50px;color: #cd201f">Add Product Form</h1>
        <p><i style="font-family: cursive;color: #cd201f;font-size: 18px">You need fill up following to add.</i></p>
        <form action="process" method="POST">
            <c:set var="err" value="${requestScope.ERRORS}"/>

            <div  class="form-group" style="width: 300px;
                  margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive"for="pwd">ID:</label> 
                <input  placeholder="ID"class="form-control" type="text" name="productid" value="${param.productid}"/>
            </div>

            <c:if test="${not empty err.iderr}">

                <font color="red">${err.iderr}</font>


            </c:if>
            <div  class="form-group" style="width: 300px;
                  margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive"for="pwd">Name:</label> 
                <input placeholder="Name"class="form-control" type="txt" name="productname" value="${param.productname}"/>(2-20 chars)
            </div>

            <c:if test="${not empty err.nameerr}">

                <font color="red">${err.nameerr}</font>


            </c:if>
            <div  class="form-group" style="width: 300px;
                  margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive"for="pwd">Price:</label> 

                <input placeholder="Price"class="form-control"type="text" name="productprice" value="${param.productprice}"/>
            </div>

            <c:if test="${not empty err.priceerr}">

                <font color="red">${err.priceerr}</font>


            </c:if>
            <div  class="form-group" style="width: 300px;
                  margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive"for="pwd">Img URL:</label> 

                <input placeholder="Img URL"class="form-control"type="text" name="productimg" value="${param.productimg}"/>
            </div>


            <c:if test="${not empty err.imgerr}">

                <font color="red">${err.imgerr}</font>

            </c:if>
            <div  class="form-group" style="width: 300px;
                  margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive"for="pwd">Category:</label> 
                <select class="form-control" name="categories">
                    <c:if test="${not empty sessionScope.category}">
                        <c:forEach var="c" items="${sessionScope.category}">
                            <option>${c.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>

            <br/>
            <input style="font-size: 20px"class="btn btn-primary"type="submit" value="Add" name="btAction" />
            </br></br> 
            <b><a style="font-family: cursive;font-size: 20px" class="btn-primary" href="process?btAction=Manage Products">Back</a></b>

        </form>
    </center> 

</body>
</html>
