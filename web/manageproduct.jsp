

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Products</title>
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
            .hehe{

                background-image:url(https://wallpapershome.com/images/pages/pic_h/12576.jpg);
                /*                background-color: black;
                                background-position: center;*/
            }
        </style>
    </head>
    <body class="hehe">
    <center>
        <form action="process" method="POST"> 

            <h2><font style="font-family: cursive;font-size:30px"color="black">Hello, ${sessionScope.fn}</font></h2>
            <table>
                <tr>
                    <td><input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px"class="haha" type="submit" value="Back Home" name="bt" /></td>
                    <td><input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px"class="haha" type="submit" value="Add New Product" name="btAction" /></td>
                    <td><input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px"class="haha"type="submit" value="Add New Category" name="btAction" /></td>
                    <td><input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px"class="haha" type="submit" value="Logout" name="btAction" onclick="return confirm('Are you sure to Logout ?')"/></td> 
                </tr>
            </table>
            <br/>
            <table>
                <tr>
                    <td><input style="width:268px;height:30px;margin: 13px;font-family: cursive;font-size: 20px"placeholder="Enter Name Product"type="text" name="searchValue" value="${param.searchValue}"/></td>
                    <td><input style="font-family: cursive;border-color: lightgreen;background-color: lightgreen;color: black;font-size: 20px" class="haha"type="submit" name="btAction" value="Search Name"/></td>
                </tr>
            </table>
            <c:if test="${not empty productsearch}">
                <br/>
                <table class=" table-bordered table-hover"width="50%" border="1" style="background-color: snow;font-family: cursive;font-size: 16px">
                    <thead>
                        <tr>
                            <th  style="font-family: cursive">Number</th>
                            <th  style="font-family: cursive">ID</th>
                            <th  style="font-family: cursive">Name</th>
                            <th  style="font-family: cursive">Price</th>
                            <th  style="font-family: cursive">Image URL</th>
                            <th  style="font-family: cursive">IsDelete</th>
                            <th  style="font-family: cursive">Category</th>
                            <th  style="font-family: cursive"colspan="2">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="0"/>
                        <c:forEach var="product" items="${productsearch}">
                            <c:set var="count" value="${count+1}"/>
                            <tr>
                                <td style="font-family: cursive">${count}</td>
                                <td style="font-family: cursive">${product.id}</td>
                                <td style="font-family: cursive">${product.name}</td>
                                <td style="font-family: cursive">${product.price}</td>
                                <td style="font-family: cursive">${product.img}</td>
                                <td style="font-family: cursive">${product.isdelete}</td>
                                <td style="font-family: cursive">${product.idcategory}</td>
                                <td style="font-family: cursive"align="center"><a class="huhu" href="process?btAction=Update Product&id=${product.id}">Edit</a></td>
                                <td style="font-family: cursive"align="center"><a class="huhu" href="process?btAction=Delete Product&id=${product.id}" 
                                                                                  onclick="return confirm('Are you sure to Delete ?')">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${not empty value}">     
                <c:if test="${empty productsearch}">
                    <p><font style="font-family: cursive;font-size: 22px"color="red">No result of '${value}'</font></p>
                    </c:if>
                </c:if>    
                <%--category--%>
                <c:if test="${not empty sessionScope.category}">
                <br/>    
                <table  class="table-bordered table-hover" style="background-color: mistyrose;font-family: serif;font-size: 22px;border : 2px solid #17a2b8">
                    <tr>
                        <c:forEach var="c" items="${sessionScope.category}">
                            <td><a class="haha"href="process?btAction=Get Category2&id=${c.name}">${c.name}  </a></td>
                        </c:forEach>
                    </tr>
                </table>
            </c:if>     
            <c:if test="${not empty productcategory}">
                <p class="huhu" style="color: navy">_${name}_</p>
                <table class=" table-bordered table-hover"width="80%" border="1px solid #17a2b8" style="background-color: snow">
                    <thead>
                        <tr>
                            <th style="font-family: cursive">Number</th>
                            <th style="font-family: cursive">ID</th>
                            <th style="font-family: cursive">Name</th>
                            <th style="font-family: cursive">Price</th>
                            <th style="font-family: cursive">Image URL</th>
                            <th style="font-family: cursive">IsDelete</th>
                            <th style="font-family: cursive">Category</th>
                            <th style="font-family: cursive"colspan="2">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="0"/>
                        <c:forEach var="product" items="${productcategory}">
                            <c:set var="count" value="${count+1}"/>
                            <tr>
                                <td style="font-family: cursive">${count}</td>
                                <td style="font-family: cursive">${product.id}</td>
                                <td style="font-family: cursive">${product.name}</td>
                                <td style="font-family: cursive">${product.price}</td>
                                <td style="font-family: cursive">${product.img}</td>
                                <td style="font-family: cursive">${product.isdelete}</td>
                                <td style="font-family: cursive">${product.idcategory}</td>
                                <td style="font-family: cursive"align="center"><a class="huhu" href="process?btAction=Update Product&id=${product.id}">Edit</a></td>
                                <td style="font-family: cursive"align="center"><a class="huhu" href="process?btAction=Delete Product&id=${product.id}" 
                                                                                  onclick="return confirm('Are you sure to Delete ?')">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty productcategory}">
                <p><font color="grey">${name}</font></p>
                </c:if>    




            <c:if test="${not empty sessionScope.listproduct}">
                </br></br> <h2 style="font-family: cursive;color: #cd201f;font-size: 44px"class="huhu">List of Products</h2>
                <table class=" table-bordered table-hover"width="100%" border="1px solid #17a2b8" style="background-color: snow">
                    <thead>
                        <tr>
                            <th style="font-family: cursive"color="black" class="huhu">Number</th>
                            <th style="font-family: cursive"color="black" class="huhu">ID</th>
                            <th style="font-family: cursive"color="black" class="huhu">Name</th>
                            <th style="font-family: cursive"color="black" class="huhu">Price</th>
                            <th style="font-family: cursive"color="black" class="huhu">Image URL</th>
                            <th style="font-family: cursive"color="black" class="huhu">IsDelete</th>
                            <th style="font-family: cursive"color="black" class="huhu"> Category</th>
                            <th style="font-family: cursive"color="black" class="huhu"colspan="2">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="0"/>
                        <c:forEach var="product" items="${sessionScope.listproduct}">
                            <c:set var="count" value="${count+1}"/>
                            <tr>
                                <td style="font-family: cursive">${count}</td>
                                <td style="font-family: cursive">${product.id}</td>
                                <td style="font-family: cursive">${product.name}</td>
                                <td style="font-family: cursive">${product.price}VNĐ</td>
                                <td style="font-family: cursive">${product.img}</td>
                                <td style="font-family: cursive">${product.isdelete}</td>
                                <td style="font-family: cursive">${product.idcategory}</td>
                                <td style="font-family: cursive"align="center"><a class="huhu" href="process?btAction=Update Product&id=${product.id}">Edit</a></td>
                                <td style="font-family: cursive"align="center"><a class="huhu"href="process?btAction=Delete Product&id=${product.id}" 
                                                                                  onclick="return confirm('Are you sure to Delete ?')">Delete</a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <br/>

        </form>


    </center>    

</body>
</html>
