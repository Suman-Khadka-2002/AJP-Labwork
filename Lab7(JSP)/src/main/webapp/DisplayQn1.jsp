<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print 10 times</title>
</head>
<body>

<%-- display "Kathmandu, Nepal" 10 times --%>
<%
    for (int i = 0; i < 10; i++) {

        out.print("Kathmandu, Nepal<br>");

    }
%>

</body>
</html>
