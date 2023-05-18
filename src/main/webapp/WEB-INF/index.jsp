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
	<nav class="navbar navbar-light bg-light">
		  <div class="container">
		    <a class="navbar-brand" href="#">
		      <img src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24">
		    </a>
		  </div>
		</nav>
   <div id="welcome-page">
   		
   </div>
   <script type="text/javascript">
const settings = {
    async: true,
    crossDomain: true,
    url: 'https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name=%3CREQUIRED%3E&value=%3CREQUIRED%3E&SessionID=%3CREQUIRED%3E',
    method: 'POST',
    headers: {
        'X-RapidAPI-Key': '3c1fe96527mshf1a599531d3e26dp1724b4',
        'X-RapidAPI-Host': 'endlessmedicalapi1.p.rapidapi.com'
    }
};

$.ajax(settings).done(function (response) {
    // console.log(response);
    let news = document.getElementById("api-news");
    news.innerText = response
    news.innerHTML = response
});

</script>
</body>
</html>

