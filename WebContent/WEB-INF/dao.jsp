<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Dao Example</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
		
		<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
	
	    <form method="post" action="dao">
	        <p>
	            <label for="firstName">Prénom : </label>
	            <input type="text" name="firstName" id="firstName" />
	        </p>
	        <p>
	            <label for="lastName">Nom : </label>
	            <input type="text" name="lastName" id="lastName" />
	        </p>
	        
	        <input type="submit" />
	    </form>
	    
	    <ul>
	        <c:forEach var="user" items="${ users }">
	            <li><c:out value="${ user.firstName }" /> <c:out value="${ user.lastName }" /></li>
	        </c:forEach>
	    </ul>    
	</body>
</html>