<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Asset Management System</title>
  <link rel="stylesheet" href="style.css">


</head>

<body>
  <div class="wrapper">

    <nav>

      <header>
        <span></span>
        <%=session.getAttribute("username")%>
        <a></a>
      </header>

      <ul>
          <li><span>NAVIGATION</span></li>
          <li><a href="user.jsp">Dashboard</a></li>
          <li><a href="requestAsset.jsp" class="active">Request Asset</a></li>
          <li><a href="returnAsset.html">Return Asset</a></li>
          <li><a>Update Profile</a></li>
          <li><a>Logout</a></li>
        </ul>
    </nav>

    <main>

      <h1>Asset Management System</h1><hr>
      <h3>Request Asset</h3>


      <div class="flex-grid">
        <div>
          <h2><strong>Select Asset</strong></h2>
          <form>
      <select class="category-dropdown">
        <option value="phone">Phone</option>
        <option value="laptop">Laptop</option>
        <option value="charger">Charger</option>
      </select>
      <button type="button" name="button" class="requestButton">Submit</button>
    </form>

        </div>


      </div>



    </main>

  </div>

</body>

</html>