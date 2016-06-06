<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/routing.js"></script>

<!-- CSS -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- Controllers -->
<script type="text/javascript" src="angular/Controllers/AnnoncesController.js"></script>
<!-- Directives -->
<script type="text/javascript" src="angular/Directives/AnnonceDecorator.js"></script>
<!-- Services -->
<script type="text/javascript" src="angular/Services/AnnonceProvider.js"></script>
<title>Annonces</title>
</head>
<body ng-app='myapp'>




<div ng-view></div>





</body>
</html>