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
    <!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

	<nav class="navbar navbar-light bg-light" >
		  <div class="container" >
		    <a class="navbar-brand" href="/">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <a class="btn btn-success" href="/logout" role="button">LogOut</a> 
		  </div>
		</nav>
	<div class="admin-body">
		<form:form action="/addClinic" method="post" modelArribute="newClinic">
		<div class="clinic-in">
			<h4 style="color:#198754;">Add a new clinic</h4>
			<div class="form-outline mb-4">
            <input type="text" id="form3Example3" path="name" class="form-control form-control-lg"
              placeholder="Clinic Name" />
            
          </div>
          <div class="form-outline mb-4">
            <input type="email" id="form3Example3" path="email" class="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            
          </div>
          <div class="form-outline mb-4">
            <input type="text" id="form3Example3" path="phone" class="form-control form-control-lg"
              placeholder="Phone No." />
            
          </div>
          <div class="form-outline mb-4">
            <input type="text" id="form3Example3" path="address" class="form-control form-control-lg"
              placeholder="Address" />
            
          </div>
          <div class="form-outline mb-4">
            <input type="password" id="form3Example3" path="password" class="form-control form-control-lg"
              placeholder="Password" />
            
          </div>
          <div class="form-outline mb-4">
            <input type="password" id="form3Example3" path="confirm" class="form-control form-control-lg"
              placeholder="Confirm Password" />
            
          </div>
      
          <input class="btn btn-success" id="toright" type="submit" value="Create Clinic">
          </form:form>
		</div>
		<div class="clinic-table">
			<h4 style="color:#198754;">Clinics</h4>
   			<table class="table">
			  <thead style="background-color:#198754;">
			    <tr>
			      
			      <th scope="col">Clinic Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone No.</th>
			      <th scope="col">Address</th>
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