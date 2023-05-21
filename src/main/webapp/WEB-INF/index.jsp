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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    
</head>
<body onload="getEndlessAPIData()">
	<nav class="navbar navbar-light bg-light" >
		  <div class="container" >
		    <a class="navbar-brand" href="/">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <div>
		    <a class="btn btn-success"  href="/cliniclogin" role="button" style="margin-bottom:5px; padding-right:18px; padding-left:15px;">LogIn As Clinic</a><br>
		    <a class="btn btn-success"  href="/doctorlogin" role="button" style="margin-bottom:5px; ">LogIn As Doctor</a> 
		    </div>
		  </div>
		</nav>
   <div id="welcome-page" style="width:100%; height:500px;">
   		
   </div>
   

</body>

<script defer="defer">
	 let getEndlessAPIData= function(){
		 const settings = {
					async: true,
					crossDomain: true,
					url: 'https://endlessmedicalapi1.p.rapidapi.com/GetFeatures',
					method: 'GET',
					headers: {
						'X-RapidAPI-Key': '3c1fe96527mshf1a599531d3e26dp1724b4jsn885c10d9cb5f',
						'X-RapidAPI-Host': 'endlessmedicalapi1.p.rapidapi.com'
					}
				};

		 $.ajax(settings).done(function(response) {
				
				let div = document.getElementById("welcome-page");
				let data=""
				for (let i=0; i<10; i++) {
					data+= response.data[i] + "\n"
				}
				div.innerText= data
				console.log(response);
			});
			
		}
		
	</script>
</html>

