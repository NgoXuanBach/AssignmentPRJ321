
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
       

        
        <style type="text/css">

            .hehe
            {
                background-image:url(https://wallpapershome.com/images/pages/pic_h/16351.jpg);
            }

        </style>

    </head>

    <body class="hehe">

    <center>
        <h1 style="font-family: cursive;color: blue">Register An Account</h1>
        <form action="process" method="POST">
            <c:set var="err" value="${requestScope.ERRORS}"/>
            <div class="form-group" style="width: 364px;
                 margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive;font-size: 20px"for="pwd">UserName:</label>
                <input style="font-size: 20px"placeholder="Username"class="form-control" type="text" name="txtUn" value="${param.txtUn}"/>(6-20 chars)
            </div>
            <c:if test="${not empty err.usernameErr}">
                <font color="red">${err.usernameErr}</font>
            </c:if>
                <div class="form-group"style="width: 364px;
                     margin: auto;font-family: cursive;padding: 2px">
                    <label style="font-family: cursive;font-size: 20px" for="pwd">Password:</label>
                    <input style="font-size: 20px" placeholder="Password" class="form-control" type="password" name="txtPw" value="${param.txtPw}"/>(6-20 chars)
            </div>
            <c:if test="${not empty err.passwordErr}">
                <font color="red">${err.passwordErr}</font>
            </c:if>
            <div class="form-group"style="width: 364px;
                 margin: auto;font-family: cursive;padding: 2px">
                <label style="font-family: cursive;font-size: 20px" for="pwd">Confirm Password:</label>
                <input style="font-size: 20px" placeholder="Confirm" class="form-control"type="password" name="txtConfirm" value="${param.txtConfirm}"/>
            </div>
            <c:if test="${not empty err.confirmErr}">
                <font color="red">${err.confirmErr}</font>
            </c:if>
            <div class="form-group"style="width: 364px;
                 margin: auto;font-family: cursive;padding: 2px">
                <label  style="font-family: cursive;font-size: 20px" for="pwd">Full name:</label>
                <input style="font-size: 20px" placeholder="Fullname"class="form-control"type="text" name="txtFullname" value="${param.txtFullname}"/>(5-50 letters)

            </div>
            <c:if test="${not empty err.fullnameErr}">
                <font color="red">${err.fullnameErr}</font>
            </c:if>
            <c:if test="${not empty err.duplicateUsername}">
                <font color="red">${err.duplicateUsername}</font>
            </c:if>    
            <br/>
            <input style="font-size: 20px" class="btn btn-primary" type="submit" value="Register Account" name="btAction" />
            </br></br> <b><a style="font-family: cursive;font-size: 20px
                  " class="btn-primary"href="process" >Back to Login Page</a></b>
        </form>
    </center> 

</body>
</html>
