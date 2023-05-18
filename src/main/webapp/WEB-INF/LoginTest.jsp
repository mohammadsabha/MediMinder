<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- Formatting (dates) -->
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!-- form:form -->
            <%@ taglib prefix="form"
                uri="http://www.springframework.org/tags/form"%>
                <!-- for rendering errors on PUT routes -->
                <%@ page isErrorPage="true" %>
                    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
 <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body >
<div style="display:flex;justify-content:flex-start;align-items:center;flex-direction:column">
<img src="/images/logo2.png"  width="300" height="220">

<div class="col-4" style="margin:0 auto;">

<h3 class="text-center h3 my-3">Welcome to MediMendir</h3>
<form action="/login" method="post"  class="">
<div class="d-grid mb-3 ">
<label class="form-label">Email</label>
<input  class="form-control"/>
</div>
<div class="d-grid mb-3">
<label  class="form-label">Password</label>
<input  class="form-control" type="password" />
</div>
<div class="d-grid mb-3 ">
<input type="submit" value="Login" class="btn btn-primary"/>
</div>
<div  class="d-grid">
</div>
</form>
</div>
</div>
</body>
</html>