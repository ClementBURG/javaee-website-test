<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Session</title>
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<c:if test="${ !empty sessionScope.firstName && !empty sessionScope.lastName }">
	        <p>Vous êtes ${ sessionScope.firstName } ${ sessionScope.lastName } !</p>
	    </c:if>
	    <form method="post" action="session">
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
  	</body>
</html>