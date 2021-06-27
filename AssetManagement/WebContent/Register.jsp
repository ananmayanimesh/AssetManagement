<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="registerstyle.css">
<title>Register</title>
</head>
<body>

	<h1>
		Register Form <span>for Asset Management</span>
	</h1>
	<div class="main">
		<p class="sign" align="center">Registration</p>
		<form action="UserRegistration" class="formLogin" method="POST">

			<input class="formstyle " type="text" name="name" align="center"
				id="name" placeholder="Name" required>
			<div align="center" id="div1"></div>

			<br> <select class="formstyle" name="role" align="center"
				id="role">
				<option value="Admin">admin</option>
				<option value="Borrower">borrower</option>
			</select>
			<div align="center" id="div2"></div>

			<br> <input class="formstyle " type="number" name="telephone"
				align="center" id="telephone" placeholder="Telephone" required
				onkeyup="phone_validation()">
			<div align="center" id="div3"></div>

			<br> <input class="formstyle " type="text" name="username"
				align="center" id="uname" placeholder="Username" required>
			<div align="center" id="div4"></div>

			<br> <input class="formstyle " type="Email" name="email"
				align="center" id="email" placeholder="Email id" required>
			<div align="center" id="div5"></div>

			<br> <input class="formstyle" type="password" name="pswd"
				align="center" id="password" placeholder="Password" required
				onkeyup="pwd_validation()">
			<div id="div6" align="center"></div>

			<br> <input class="formstyle " type="password" name="cnfmpswd"
				align="center" id="repassword" placeholder="re-type password"
				required onkeyup="repwd_validation()">
			<div id="div7" align="center"></div>
			<br>


			<p class="terms" align="center" id="terms">
				<input type="checkbox" id="terms" value="terms" required /> <label>accept
					all terms and conditions</label>
			<div id="div8" align="center"></div>
			<br>

			</p>

			<button class="submit" align="center" type="submit" >Register</button>

		</form>
	</div>
</body>
<script type="text/javascript" src="formvalidation.js"></script>
</html>