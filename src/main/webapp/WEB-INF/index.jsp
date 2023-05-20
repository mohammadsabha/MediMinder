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
<body onload="function (response)">
	<nav class="navbar navbar-light bg-light" >
		  <div class="container" >
		    <a class="navbar-brand" href="#">
		      <img src="/images/Background.png" alt="" width="200px;" height="160px;">
		    </a>
		    <a class="btn btn-success"  href="/login" role="button">LogIn</a> 
		  </div>
		</nav>
   <div id="welcome-page" style="width:100%; height:500px;">
   		
   </div>
   <script type="text/javascript">
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

		$.ajax(settings).done(function (response) {
		
			document.getElemetById("welcome-page");
			console.log(response);
		});
	</script>

</body>
</html>

