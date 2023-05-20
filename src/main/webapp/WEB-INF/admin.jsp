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
    <title>java</title>
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
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
	<div class="admin-body">
		<div class="clinic-in">
			<h4 style="color:#198754;">Add a new patient</h4>
			<div class="form-outline mb-4">
            <input type="text" id="form3Example3" class="form-control form-control-lg"
              placeholder="Clinic Name" />
            <label class="form-label" for="form3Example3">Clinic Name</label>
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
          <div class="form-outline mb-4">
            <input type="text" id="form3Example3" class="form-control form-control-lg"
              placeholder="Address" />
            <label class="form-label" for="form3Example3">Address</label>
          </div>
          <div class="form-outline mb-4">
            <input type="password" id="form3Example3" class="form-control form-control-lg"
              placeholder="Password" />
            <label class="form-label" for="form3Example3">Password</label>
          </div>
          <div class="form-outline mb-4">
            <input type="password" id="form3Example3" class="form-control form-control-lg"
              placeholder="Confirm Password" />
            <label class="form-label" for="form3Example3">Confirm Password</label>
          </div>
          <a class="btn btn-success" id="add-pnt" href="#" role="button">Add Clinic</a>
		</div>
		<div class="clinic-table">
			<h4 style="color:#198754;">Clinics</h4>
   			<table class="table">
			  <thead style="background-color:#198754;">
			    <tr>
			      
			      <th scope="col">Clinic Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone No.</th>
			      <th scope="col">Adress</th>
			    </tr>
			  </thead>
			  <tbody>
			  <C:forEach var="clinic" items="${allClinics}">
			    <tr>
			      
			      <td>${clinic.name}</td>
			      <td>${clinic.email}</td>
			      <td>${clinic.phone}</td>
			      <td>${clinic.address}</td>
			    </tr>
			   </C:forEach> 
			   </tbody>
			</table>
		</div>
	</div>	
</body>
</html>
