<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MediMinder</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<nav class="navbar navbar-light bg-light">
	  <div class="container">
	    <a class="navbar-brand" href="#">
	      <img src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24">
	    </a>
	    <a class="logout" href="/logout">LogOut</a>
	  </div>
	</nav>
   <div class="body-container">
   		<div class="dr-table">
   			<h4>Doctors</h4>
   			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Dr. Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Address</th>
			      <th scope="col">Phone No.</th>
			    </tr>
			  </thead>
			  <tbody>
			  <C:forEach var="dr" items="${allDoctors}">
			    <tr>
			      <td>${dr.name}</td>
			      <td>${dr.email}</td>
			      <td>${dr.address}</td>
			      <td>${dr.phone}</td>
			    </tr>
			   </C:forEach>
			   </tbody>
			</table>
			<button type="button" class="btn btn-success" href="/createdoctor">Add Doctor</button>
			<a class="btn btn-success" id="add-dr" href="/createdoctor" role="button">Add Doctor</a>
   		</div>
   		<div class="pnt-table">
   			<h4>Patients</h4>
   			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone No.</th>
			    </tr>
			  </thead>
			  <tbody>
			  <C:forEach var="pnt" items="${allPatients}">
			    <tr>
			      <td>${pnt.name}</td>
			      <td>${pnt.email}</td>
			      <td>${pnt.phone}</td>
			    </tr>
			   </C:forEach> 
			   </tbody>
			</table>
   		</div>
   </div>
</body>
</html>
