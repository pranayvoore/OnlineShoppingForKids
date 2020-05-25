<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
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
				style="margin-left: 177px;">
			<ul class="nav">
				<li class="nav-item "><a href="" class="btn btn-primary"
					data-toggle="modal"><i class='fas fa-portrait'></i>&nbsp;Welcome ${uname}
				</a></li>&nbsp;
				<form action="FirstCryServlet" method="post">
					<li class="nav-item "><input type="submit" name="button"
						class="btn  btn-primary " value="LogOut" />
				</form>
			</ul>
		</nav>
	</div>
	<br>
	<br>

	<!-- form -->
	<center>
		<form action="FirstCryServlet" method="post">
			<label>Select Category:</label><br> <select
				class="form-control col-sm-2" id="sel1" name="list">
				<c:forEach items="${cList}" var="category">
					<option>${category}</option>
				</c:forEach>
			</select> <input type="submit" name="button" value="submit"
				class="btn  btn-primary">
		</form>
	</center>
	<br>
	<br>
	<!-- Table -->
	<div class="container">
		<table class="table table-hover">
			<center>
				<form action="FirstCryServlet" method="post">
				<tr>
					<th>Image</th>
					<th>Name</th>
					<th>UnitPrice</th>
					<th>Quantity</th>
				</tr>
				<c:forEach items="${pList}" var="obj">
					<tr>
					<input type="hidden" value="${obj.id}" name="itemid">
						<td><img src="images/${obj.image}"
							style="width: 50px; height: 50px"></td>
						<td>${obj.name}</td>
						<td>${obj.price}</td>
						<td><input type="number" name="quantity" min="0" value="0"></td>
					</tr>
				</c:forEach>
			</center>
		</table>
	</div>
	</div>
	<div align="center">
		<input type="submit" name="button" value="Add to Cart"
			class="btn  btn-primary">
		</form>
	</div>
</body>
</html>