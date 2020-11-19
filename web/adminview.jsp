

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Home</title>
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
                background-color: black;

                background-position: center;
            }
        </style>
    </head>
    <body class="hehe">
    <center>
        <form action="process" method="POST">
            <!--<img alt="" src="images/admin.png">-->
            <h2 ></br></br></br></br></br></br><font style="font-family: cursive;font-size:50px"color="white">Hello, ${sessionScope.fn}</font></h2>
            <table>
                <tr>
                    <td </br></br><input style="font-size: 20px;font-family: cursive;color: firebrick"class="haha" type="submit" value="Manage Products" name="btAction"/></td>
                    <td </br></br><input style="font-size: 20px;font-family: cursive;color: firebrick"class="haha"type="submit" value="Manage Users" name="btAction"/></td>
                    <td </br></br><input style="font-size: 20px;font-family: cursive;color: firebrick"class="haha" type="submit" value="View All Order" name="btAction"/></td>

                </tr>

            </table>    
            </br>
            <input  style="font-size: 20px;font-family: cursive;color: firebrick" class="haha" type="submit" value="Logout" name="btAction" onclick="return confirm('Are you sure to Logout ?')"/>
        </form>
    </center>  

</body>
</html>
