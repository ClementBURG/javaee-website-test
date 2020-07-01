<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>File Form Example</title>
	</head>
	<body>
		<%@ include file="menu.jsp" %>
	
	    <c:if test="${ !empty file }"><p><c:out value="Le fichier ${ file } (${ description }) a été uploadé !" /></p></c:if>
	    <form method="post" action="fileForm" enctype="multipart/form-data">
	        <p>
	            <label for="description">Description du fichier :</label>
	            <input type="text" name="description" id="description" />
	        </p>
	        <p>
	            <label for="file">Fichier à envoyer : </label>
	            <input type="file" name="file" id="file" />
	        </p>
	        
	        <input type="submit" />
	    </form>
	    
	</body>
</html>