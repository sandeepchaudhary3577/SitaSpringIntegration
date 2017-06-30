<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringIntegrationProject></title>
</head>
<style>
table1, th, td {  
    border: 2px solid black;  
    border-collapse: collapse;  
} 

body {background-color: powderblue;}
h5   {color: blue;}
p    {color: red;}
</style>


<body>
<h1>
<table>
<tr>
<td align="right"><p>Spring Integration Process Running background</p></td>
</tr>
</table>
<table id="table1">
<tr>
<td><h5>Input directory location </td><td><spring:eval expression="@propertyConfigurer.getProperty('INPUT.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Output directory location </td><td><spring:eval expression="@propertyConfigurer.getProperty('OUTPUT.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Process directory location </td><td> <spring:eval expression="@propertyConfigurer.getProperty('PROCESS.DIRECTORY')" /></h5></td>
</tr>
<tr>
<td><h5>Error directory location </td><td><spring:eval expression="@propertyConfigurer.getProperty('ERROR.DIRECTORY')" /></h5></td>

</tr>
</table>

</h1>
</body>
</html>
