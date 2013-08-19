<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<body>

<style>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</style>

	<h1>${homeModel.message}</h1>
	<form:form modelAttribute="homeModel" method="POST" action='${pageContext.request.contextPath}/home/validate'>
	
	<form:errors path="*" cssClass="errorblock" element="div" />
	
	First Name : <form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/></br>
	Last Name : <form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/></br>
	Password : <form:password path="password"/><form:errors path="password" cssClass="error"/></br>
	<input type="submit" value="Validate"></br>
	</form:form>	
</body>
</html>