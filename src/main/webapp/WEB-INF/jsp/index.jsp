<%@page import="com.java.controller.Captcha" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<title>Login</title>
<style>
.login-container{
    margin-top: 10%;
    margin-bottom: 10%;
}
.login-container{
    margin-left: 30%;
    margin-right: 30%;
}
.login-form-1{
    padding: 5%;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
}
.login-form-1 h3{
    text-align: center;
    color: #333;
}
.
.login-container form{
    padding: 10%;
}
.btnSubmit
{
    width: 50%;
    border-radius: 2rem;
    padding: 2.5%;
    border: none;
    cursor: pointer;
}
.login-form-1 .btnSubmit{
    font-weight: 600;
    color: #fff;
    background-color: #0062cc;
    
}
.login-form-1 .registration{
    color: #0062cc;
    font-weight: 600;
    text-decoration: none;
}
</style>
<body>
<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    <h3>Login Form</h3>
                    <form  action="action1" method="post">
                        <div class="form-group">
                            <input name="username" type="text" class="form-control" placeholder="Your UserName *" value="" />
                        </div>
                        <div class="form-group">
                            <input name="password" type="password" class="form-control" placeholder="Your Password *" value="" />
                        </div>
                        
                        
                        
                     
 

<input type="text" name="captcha2" id="txt_cap">

 

<%
String s=Captcha.createCap();
%>

<input name="captcha1" value="<%=s%>" size="10" type="text" readonly>

<br><br>



  <button id="submit" type="submit" value="submit" class="btn btn-primary center" onclick="alert(validCaptcha())";>Login</button>
                    </form>  <div class="form-group">
                            <a href="register" class="registration">New Registration?</a>
                        </div>
                </div>
                </div>
            </div>
       
        ${message}
        </body>
        </html>