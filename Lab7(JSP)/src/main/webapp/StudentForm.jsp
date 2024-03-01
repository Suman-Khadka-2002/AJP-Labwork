<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Information Form</title>
</head>
<body>
<h2>Student Information Form</h2>
	
	<form action="PrintFormData.jsp" method="post">
		<label for="name">Name: </label>
		<input type="text" name="name" required><br><br> 
		
		<label for="rollNumber">Roll Number:</label> 
		<input type="text" name="rollNumber" required><br><br> 
		
		<label for="course">Course:</label> 
		<input type="text" name="course" required><br><br> 
		
		<input type="submit" value="Submit"> 
	</form>

</body>
</html>