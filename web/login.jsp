<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style type="text/css">
            .lala
            {

                background-image:url(https://wallpapershome.com/images/pages/pic_h/18938.jpg);


            }
            .hihi
            {

                font-family: cursive;
                color: mintcream;
                font-size: 56px;


            }
        </style>
    </head>
    <body class="lala">
    <center>
        </br></br></br>
        <h1  class="hihi" style="color:blue ">Login Page</h1>
        <form action="process" method="POST">
            <div class="form-group" style="width: 364px;
                 margin: auto;font-family: cursive;padding: 2px">
                <label style="font-size: 20px" style="font-family: cursive"for="pwd">UserName:</label>
                <input style="font-size: 20px" placeholder="Username"class="form-control" type="text" name="txtUsername" value="${param.txtUsername}" />
            </div>
            <div class="form-group"style="width: 364px;
                 margin: auto;font-family: cursive;padding: 2px">
                <label style="font-size: 20px" for="pwd">Password:</label>
                <input style="font-size: 20px" placeholder="Password" class="form-control" type="password" name="txtPassword" value="${param.txtPassword}"/>
            </div>
            <c:if test="${not empty err}">
                <font color="darkred">${err}</font>
            </c:if>
            </br>
            <input style="font-size: 20px"class="btn btn-primary" type="submit" value="Login" name="btAction" />
            <input style="font-size: 20px" class="btn btn-primary" type="submit" value="Register" name="btAction" />
        </form>
    </center>
</body>
</html>
