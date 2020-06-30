<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<c:if test="${ !empty form.result }"><p><c:out value="${ form.result }" /></p></c:if>
    	
    	<form method="post" action="form">
	    	<p>
	    		<label for="login">Login :</label>
	    		<input type="text" name="login" id="login" />
	   		</p>
	   		<p>
	    		<label for="pass">Password :</label>
	    		<input type="password" name="pass" id="pass" />
	   		</p>
	   		
    		<input type="submit">
    	</form>
    	<!-- action="form" means the form will be sent to /form url corresponding servlet -->
	</body>
</html>