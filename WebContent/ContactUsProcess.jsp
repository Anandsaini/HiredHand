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
String CONTACT_US_NAME,CONTACT_US_EMAIL,CONTACT_US_MESSAGE;
CONTACT_US_NAME=request.getParameter("name");
CONTACT_US_EMAIL=request.getParameter("email");
CONTACT_US_MESSAGE=request.getParameter("message");
try{
	if(new ContactUsDao(CONTACT_US_NAME,CONTACT_US_EMAIL,CONTACT_US_MESSAGE).connection_Check())
{
	response.sendRedirect("thankyou.html");
	
}
else
{
	response.sendRedirect("success.html");
}
}
catch(Exception e)
{
	response.sendRedirect("error.html");
	e.printStackTrace();
}


%>
</body>
</html>