<%@page import="com.java.controller.Captcha" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel='stylesheet' type="text/css"/> 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<h1 style="color:black" style= "margin-top:15px" >
	<center>
		<span class="glyphicon glyphicon-user" style="color: black">
		</span>
			Registration Form
	</center>
	</h1> 
</head>
<body>
       <div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
              <div class="panel panel-primary">
                     <div class="panel-heading">Enter Your Details Here
                     </div>
                     
                     <div class="panel-body">
                         
                                      <form name="myform" action="action" method="post">
                                         
                                        <div class="form-group">
                     
                                         <label for="usname">User Name</label>
                                         <input id="usname" name="username" class="form-control" type="textArea" required>
                                         <span id="error_name" class="text-danger"></span>
                                         
                                  </div>
                                   <div class="form-group">
                                         <label for="emailaddress">Email Address</label>
                                         <input id="emailaddress" name="email" class="form-control" type="email" required>
                                         <span id="error_name" class="text-danger"></span>
                                         
                                  </div>
                                 
              
                                        <div class="form-group">
                     
                                         <label for="password">Password</label>
                                         <input id="password" name="password" class="form-control" type="password" required>
                                         <span id="error_name" class="text-danger"></span>
                                  </div>
                               
                                  <input type="text" name="captcha2" id="txt_cap">
								  <%String s=Captcha.createCap();%>
							      <input  type="text" name="captcha1" value="<%=s%>" size="10" readonly>
								  <br><br>
								  <button id="submit" type="submit" value="submit" class="btn btn-primary center" onclick="alert(validCaptcha())">Submit</button>
                   				  <button id="reset" type="reset" value="reset" class="btn btn-primary center">Reset</button>
                           
 </form>                    
                   
</div></div>
                     
   ${message}                 
              </div>
       </div>
</body>
</html>

