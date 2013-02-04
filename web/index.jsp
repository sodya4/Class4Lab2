<%-- 
    Document   : index
    Created on : Feb 2, 2013, 8:31:43 AM
    Author     : scottodya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script language="javascript" type="text/javascript">
            function validateNegNum() {
                var x=document.forms["form1"]["neg_num"].value;
                if (x==null || x=="")
                {
                    alert("Number must be non-negative.");
                    return false;
                }
            }
        </script>

    </head>
    <body>
        <h1>Lab 2 Challenge 2!</h1>
        <h2 align="center">Calculators</h2>
        <hr/>
        <h3 align="center">Calculate area of a rectangle</h3>
        <form id="form1" name="form1" method="POST" action="RectangleServlet" onsubmit="return validateNegNum()">
            Input Length: <input id="length" type="text" name="length"><br>
            Input Width: <input id="width" type="text" name="width"><br>
            <br>
            <input id="rectangleSubmit" name="rectangleSubmit" type="submit" value="Calculate">

        </form>
        <%  if (request.getAttribute("answer_rectangle") != ("")){
            double ans = (Double) request.getAttribute("answer_rectangle");
            out.print(ans);
            }
        %>
        <hr/>
        <h3 align="center">Calculate area of a circle</h3>
        <form id="form2" name="form2" method="POST" action="CircleServlet"onsubmit="return validateNegNum()">
            Input Radius <input id="length" type="text" name="radius"><br>
            <br>
            <input id="circleSubmit" name="circleSubmit" type="submit" value="Calculate">

        </form>
        <%  if (request.getAttribute("answer_circle") != ("")){
            double ans = (Double) request.getAttribute("answer_circle");
            out.print(ans);
        %>
        <hr/>
        <h3 align="center">Calculate the third side of a right triangle</h3>
        <form id="form3" name="form3" method="POST" action="TriangleServlet"onsubmit="return validateNegNum()">
            Input Side a <input id="sidea" type="text" name="sidea"><br>
            Input Side b <input id="sideb" type="text" name="sideb"><br>
            Input Side c <input id="sidec" type="text" name="sidec"><br>
            <br>
            <input id="triangleSubmit" name="triangleSubmit" type="submit" value="Calculate">

        </form>
        <%  if (request.getAttribute("answer_triangle") != ("")){
            ans = (Double) request.getAttribute("answer_triangle");
            out.print(ans);
        %>
    </body>
</html>
