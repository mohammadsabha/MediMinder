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
		    <a class="navbar-brand" href="/doctorhome">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <a class="btn btn-success" href="/logout" role="button">LogOut</a> 
		  </div>
		</nav>
	<div class="dr-body">
		<div class="dr-in">
			<h4 style="color:#198754;">Add a new patient</h4>
			<form:form action="/createPatient" method="post" modelAttribute="patient">
			<div class="form-outline mb-4">
            <input type="text" id="form3Example3" path="name" class="form-control form-control-lg"
              placeholder="Patient Name" />
            <form:errors path="name" class="text-danger"/>
          </div>
          <div class="form-outline mb-4">
            <input type="email" id="form3Example3" path="email" class="form-control form-control-lg"
              placeholder="Enter a valid email address" />
            <form:errors path="email" class="text-danger"/>
          </div>
          <div class="form-outline mb-4">
            <input type="text" id="form3Example3" path="phone" class="form-control form-control-lg"
              placeholder="Phone No." />
            <form:errors path="phone" class="text-danger"/>
          </div>
          <div class="form-outline mb-4">
            <input type="date" id="form3Example3" path="date" class="form-control form-control-lg"
              placeholder="BirthDay" />
            <form:errors path="date" class="text-danger"/>
          </div>
          <button type="button" class="btn btn-success btn-lg">Add Patient</button>
          </form:form>
		</div>
		<div class="pnt-table">
			<h4 style="color:#198754;">Patients</h4>
   			<table class="table">
			  <thead style="background-color:#198754;">
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">BirthDay</th>
			      <th scope="col">Phone No.</th>
			    </tr>
			  </thead>
			  <tbody>
			  <C:forEach var="pnt" items="${allPatients}">
			    <tr>
			      <td>${pnt.name}</td>
			      <td>${pnt.email}</td>
			      <td>${pnt.date}</td>
			      <td>${pnt.phone}</td>
			    </tr>
			   </C:forEach> 
			   </tbody>
			</table>
		</div>
	</div>	
</body>
</html>