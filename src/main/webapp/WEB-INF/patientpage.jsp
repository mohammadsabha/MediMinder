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
		    <a class="navbar-brand" href="/doctorhome">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <a class="btn btn-success"  href="/doctorhome" role="button">go back</a> 
		  </div>
		</nav>
	<div class="patient-body">
	
		<div class="appointment" style="margin-top:35px;">
			<form:form action="/addAppointment/${patient.id}" method="post" modelAttribute="appointment">
			<form:input type="hidden" id="form3Example4c" path="clinic" value="${clinic_id}" class="form-control" placeholder="Password" />
			<form:input type="hidden" id="form3Example4c" path="doctor" value="${doctor_id}" class="form-control" placeholder="Password" />
			<form:input type="hidden" id="form3Example4c" path="patient" value="${patient.id}" class="form-control" placeholder="Password" />
				<div class="form-outline w-100 mb-4">
				  <form:textarea class="form-control" id="textAreaExample4" path="symptoms" rows="3" placeholder="symptoms"></form:textarea>
				  
				</div>
				<div class="form-outline w-100 mb-4">
				  <form:textarea class="form-control" id="textAreaExample4" path="diagnosis" rows="3" placeholder="diagnosis"></form:textarea>
				  
				</div>
				<div class="form-outline w-100 mb-4">
				  <form:textarea class="form-control" id="textAreaExample4" path="treatment" rows="3" placeholder="treatment"></form:textarea>
				  
				</div>
				<input class="btn btn-success" id="toright" type="submit" value="Submit">				
				</form:form>
			</div>
	
	
		<div class="ptn-right">
		<c:forEach var="apt" items="${patient.appointments}">
			<div class="list-group">
				
				<a href="#" class="list-group-item list-group-item-action">
				  <div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">Symptoms</h5>
				  </div>
				  <p class="mb-1">${apt.symptoms}</p>
				  <small class="text-body-secondary">And some muted small print.</small>
				</a>
				
				
			</div>
			<div class="list-group">
				
				<a href="#" class="list-group-item list-group-item-action">
				  <div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">Diagnosis</h5>
				  </div>
				  <p class="mb-1">${apt.diagnosis}</p>
				  <small class="text-body-secondary">And some muted small print.</small>
				</a>
				
				
			</div>
			
			<div class="list-group">
				
				<a href="#" class="list-group-item list-group-item-action">
				  <div class="d-flex w-100 justify-content-between">
					<h5 class="mb-1">Treatment</h5>
				  </div>
				  <p class="mb-1">${apt.treatment}</p>
				  <small class="text-body-secondary">And some muted small print.</small>
				</a>
				
				
			</div>
			</c:forEach> 
		
		</div>
		
		
		
		<div class="ptn-left">
			<section>
			<a href="/updatepatient/${patient.id}" style="text-decoration: none;">
			<div class="row d-flex justify-content-center">
				<div class="col-md-16 mb-5 mb-md-0">
				  <div class="card testimonial-card">
					<div class="card-up" style="background-color: #198754;"></div>
					<div class="avatar mx-auto bg-white">
					  <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(1).webp"
						class="rounded-circle img-fluid" />
					</div>
					<div class="card-body">
					  <h4 class="mb-4">${patient.name} Maria Smith</h4>
					  <hr />
					  <p class="dark-grey-text mt-4">
						<i class="fas fa-quote-left pe-2"></i>${patient.date}
					  
					</div>
				  </div>
				</div>
		</div></a>
		</section>
	</div>
	</div>

</body>
</html>
