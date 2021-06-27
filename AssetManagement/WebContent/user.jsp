<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="UTF-8">
<title>Asset Management System</title>
<link rel="stylesheet" href="style.css">


</head>

<body>
	<div class="wrapper">

		<nav> <header> <span></span> <%=session.getAttribute("username")%>

		<%
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Expires", "0");
			
		%>

		<ul>
			<li><span>NAVIGATION</span></li>
			<li><a href="user.jsp" class="active">Dashboard</a></li>
			<li><a href="requestAsset.jsp">Request Asset</a></li>
			<li><a href="returnAsset.html">Return Asset</a></li>
			<li><a>Update Profile</a></li>
			<li><a href="LogOutServlet">Logout</a></li>
		</ul></nav>

		<main>

		<h1>Asset Management System</h1>
		<hr>
		<h3>User Dashboard</h3>
		<div class="flex-grid">
			<div>
				<h2>
					<strong>Notifications</strong>
				</h2>
				<ul>
					<li>Request for a Phone</li>
					<li>Updates Available</li>
					<li>2 Assests removed from Database</li>
				</ul>
			</div>

		</div>

		<div class="flex-grid">
			<div>
				<h2>Asset Borrowed</h2>
				Phone
			</div>
			<div>
				<h2>Requested Asset</h2>
				Laptop
			</div>
		</div>



		</main>

	</div>

</body>

</html>