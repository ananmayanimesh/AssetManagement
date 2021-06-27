<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="registerstyle.css">
<title>Log In</title>
</head>
<body>

  <h1>Login Form <span>for Asset Management</span></h1>
  <div class="main">
    <p class="sign" align="center">Sign in</p>
    <form  action='LoginServlet' class="formLogin" method="post">
      <input class="formstyle " type="text"  name="username" align="center"  id="uname" 
      placeholder="Username">
      <input class="formstyle" type="password" name="password" align="center" id="password" 
      placeholder="Password">
      <input type="submit" class="submit" align="center" value="submit">
      
      <p class="forgot" align="center"><a href="#">Forgot Password?</p>
            
                
    </div>
     
</body>
</html> 