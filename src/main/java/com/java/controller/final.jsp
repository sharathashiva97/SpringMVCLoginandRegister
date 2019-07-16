<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
</head>
<body>
<a href="register">Register</a>
<h1>User List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>email</th><th>Edit</th><th>Login</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
     
   <td>${user.username}</td>  
   <td>${user.email}</td>  
   <td><a href="update">Edit</a></td>  
   <td><a href="index">Login</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
    
</body>
</html>