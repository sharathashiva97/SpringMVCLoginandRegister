<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>

</head>
<body style="text-align:center;">
<form:form method="POST" action="/Try/update">  

 <table>    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>UserName </td>   
          <td><form:input path="username"  /></td>  
         </tr>    
         <tr>    
          <td>Email</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>Password</td>    
          <td><form:input path="password" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Update" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>