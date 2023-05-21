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

		    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" class="btn btn-success" />
    </form>

		  </div>
		</nav>
	<div class="admin-body">
		<form:form action="/addClinic" method="post" modelArribute="newClinic">
		<div class="clinic-in">

			<h4 style="color:#198754;">Add a new Clinic</h4>
			<div class="form-outline mb-4">
			<form:form action="/clinicregister" method="post" modelAttribute="newClinic" >
			
            <form:input type="text" path="name" class="form-control form-control-lg" placeholder="Clinic Name" />
            <label class="form-label" for="form3Example3">Clinic Name</label>
            <form:errors path="name" class="text-danger" />
          </div>
          <div class="form-outline mb-4">
            <form:input type="email" path="email" class="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            <label class="form-label" for="form3Example3">Email address</label>
            <form:errors path="email" class="text-danger" />
          </div>
          <div class="form-outline mb-4">
            <form:input type="text" path="phone" class="form-control form-control-lg"
              placeholder="Phone No." />
            <label class="form-label" for="form3Example3">Phone No.</label>
            <form:errors path="phone" class="text-danger" />
          </div>
          <div class="form-outline mb-4">
            <form:input type="text" path="address" class="form-control form-control-lg"
              placeholder="Address" />
            <label class="form-label" for="form3Example3">Address</label>
            <form:errors path="address" class="text-danger" />
          </div>
          <div class="form-outline mb-4">
            <form:input type="password" path="password" class="form-control form-control-lg"
              placeholder="Password" />
            <label class="form-label" for="form3Example3">Password</label>
            <form:errors path="password" class="text-danger" />
          </div>
          <div class="form-outline mb-4">
            <form:input type="password" path="confirm" class="form-control form-control-lg"
              placeholder="Confirm Password" />
            <label class="form-label" for="form3Example3">Confirm Password</label>
            <form:errors path="confirm" class="text-danger" />
          </div>
          <input type="submit" value="Add Clinic" class="btn btn-success btn-lg" style="padding-left: 2.5rem; padding-right: 2.5rem;" />

		</div>
		 </form:form>
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
			  <c:forEach items="${allClinics1}" var="clinic">
			    <tr>
			      
			      <td>${clinic.name}</td>
			      <td>${clinic.email}</td>
			      <td>${clinic.phone}</td>
			      <td>${clinic.address}</td>
			    </tr>
			   </c:forEach> 
			   </tbody>
			</table>
		</div>
	</div>	
</body>
</html>