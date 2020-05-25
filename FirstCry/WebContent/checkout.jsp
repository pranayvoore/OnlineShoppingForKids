<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style type="text/css">
.table, tr, th, td {
	border: 3px solid black;
}
</style>
</head>
<body>
	<!-- nav bar  -->
	<div class="container-fluid">
		<nav class="navbar bg-warning">
			<img src="images/flogo.jpg" height="90px" width="180px"
				style="margin-left: 20px;">
			<ul class="nav">
				<!-- <li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#Login" data-toggle="modal"><i class='fas fa-unlock'></i>&nbsp;Login</a></li>&nbsp; -->
				<li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#SignUp" data-toggle="modal"> </i>&nbsp;Welcome
						${uname}
				</a></li>&nbsp;
				<li class="nav-item "><a href="logout.jsp"
					class="btn btn-primary"><i class="fas fa-"></i><i
						class='fas fa-lock'></i>&nbsp;LogOut</a></li>&nbsp;

			</ul>
		</nav>
	</div>
	<br>
	<br>
	<center>
		<lable>
		<b>Customer Name</b></lable>
		<input type="text" value="${uname}"> <br> <br>
	</center>


	<!-- Table -->
	<div class="container-fluid">
		<form action="FirstCryServlet" method="post">
			<table class="table table-hover table-striped">
				<tr>
					<th>Item Id</th>
					<th>Image</th>
					<th>Name</th>
					<th>UnitPrice</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${hp}" var="i">
					<tr>
						<td>${i.key.id}</td>
						<td><img src="images/${i.key.image}"
							style="width: 200px; height: 140px"></td>
						<td>${i.key.name}</td>
						<td>${i.key.price}</td>
						<td>${i.value}</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<br>
	<center>
		<h3>Total Order:${amount}</h3>
		<br> <input type="submit" name="button" value="continue"
			class="btn btn-primary">
		</form>

	</center>

</body>
</html>