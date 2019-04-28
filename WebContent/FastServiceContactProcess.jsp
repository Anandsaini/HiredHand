<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="_Hired_Hand.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String NAME,EMAIL,MOBILE,SERVICE,MESSAGE,CONTACT_US_NAME,CONTACT_US_EMAIL,CONTACT_US_MESSAGE;
NAME=request.getParameter("Name");
SERVICE=request.getParameter("Service");
EMAIL=request.getParameter("Email");
MOBILE=request.getParameter("Phone");
MESSAGE=request.getParameter("Message");
try{
if(new FastServiceDAO(NAME,EMAIL,MOBILE,SERVICE,MESSAGE).connectionProcess())
{
	response.sendRedirect("thankyou.html");
}
else
{
	response.sendRedirect("success.html");
}}
catch(Exception e)
{
	response.sendRedirect("error.html");
	e.printStackTrace();
}

%>
</body>
</html>