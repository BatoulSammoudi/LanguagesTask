<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Language</h1>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
		<p>
			<form:label path="name">name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">creator</form:label>
			<form:errors path="creator" />
			<form:textarea path="creator" />
		</p>
		<p>
			<form:label path="cuurentVersion">version</form:label>
			<form:errors path="cuurentVersion" />
			<form:input path="cuurentVersion" />
		</p>

		<input type="submit" value="Submit" />
	</form:form>
	<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>