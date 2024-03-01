<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Printing the values of form submission</title>
	</head>
<body>
	<h2>Student Information</h2>
	<%-- Retrieve data from the request object --%>
	
	<% 
		String name = request.getParameter("name");
		String rollNumber = request.getParameter("rollNumber");
		String course = request.getParameter("course");		
	%>
	
	<%-- Display the submitted information --%>
	
	<p><strong> Name: </strong> <%= name %></p>
	<p><strong> Roll Number: </strong> <%= rollNumber %></p>
	<p><strong> Course: </strong> <%= course %></p>
	
</body>
</html>