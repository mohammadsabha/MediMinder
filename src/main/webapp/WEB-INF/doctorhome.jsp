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
	<nav class="navbar navbar-light bg-light" >
		  <div class="container" >
		    <a class="navbar-brand" href="#">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <a class="btn btn-success"  href="/login" role="button">LogIn</a> 
		  </div>
		</nav>
	<div class="dr-body">
		<div class="dr-in">
			<h4 style="color:#198754;">Add a new patient</h4>
			<div class="form-outline mb-4">
            <input type="text" id="form3Example3" class="form-control form-control-lg"
              placeholder="Patient Name" />
            <label class="form-label" for="form3Example3">Patient Name</label>
          </div>
          <div class="form-outline mb-4">
            <input type="email" id="form3Example3" class="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            <label class="form-label" for="form3Example3">Email address</label>
          </div>
          <div class="form-outline mb-4">
            <input type="text" id="form3Example3" class="form-control form-control-lg"
              placeholder="Phone No." />
            <label class="form-label" for="form3Example3">Phone No.</label>
          </div>
          <a class="btn btn-success" id="add-pnt" href="#" role="button">Add Patient</a>
		</div>
		<div class="pnt-table">
			<h4 style="color:#198754;">Patients</h4>
   			<table class="table">
			  <thead style="background-color:#198754;">
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