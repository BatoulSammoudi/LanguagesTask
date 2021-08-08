<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>All Languages</h1>
	<table>
		<thead>
			<tr>
				<th>name</th>
				<th>creator</th>
				<th>current Version</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="language">
				<tr>
					<td><a href="/languages/${language.id}/show"><c:out value="${language.name}" /></a></td>
					<td><c:out value="${language.creator}" /></td>
					<td><c:out value="${language.cuurentVersion}" /></td>
					<td><a href="/languages/${language.id}/edit">Delete</a>  <a href="/languages/${language.id}/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="cuurentVersion">version</form:label>
        <form:errors path="cuurentVersion"/>
        <form:input path="cuurentVersion"/>
    </p>
   
    <input type="submit" value="Submit"/>
</form:form> 
	   
</body>
</html>