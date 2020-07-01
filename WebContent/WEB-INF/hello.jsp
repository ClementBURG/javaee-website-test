<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Hello</title>
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    
        <p>
        	<%
        		String message = (String) request.getAttribute("message");
        		out.println(message);
        	%>
        </p>
        <p>
        	<%
        		String heure = (String) request.getAttribute("heure");
        		if (heure.equals("jour")) {
        			out.println("Bonjour");
        		} else {
        			out.println("Bonsoir");
        		}
        	%>
        </p>
        <p>Bonjour ${ names[0] }</p>        
        <p>
        	Bonjour
        	<%
        		String name = (String) request.getAttribute("name");
        		out.println(name);
        	%>
        </p>
        <p>
        	<%
        		for (int i = 0; i < 10; i++) {
        			out.println("Ligne numero " + i + "<br />");
        		}
        	%>
        </p>
        
        <!-- Expression Language -->
        <p>Bonjour ${ empty name ? '' : name }</p>   
        <p>Bonjour ${ author.firstName } ${ author.lastName }</p>
        <p>${ author.active ? 'Vous êtes très actif !' : 'Vous êtes inactif !' }</p>
        
        <!-- JSTL -->
        <p><c:out value="<p>Bonjour !</p>"/></p>
        <p><c:out value="${ variable }" default="Valeur par défaut"/></p>
        <p><c:out value="${ variable }" escapeXml="false">Valeur par défaut</c:out></p>
        
        <c:set var="pseudo" value="theo" scope="page" />
        <p><c:out value="${ pseudo }"/></p>
        <!-- <c:set var="pseudo" value="theo" scope="request" />
        <c:set var="pseudo" value="theo" scope="session" />
        <c:set var="pseudo" value="theo" scope="application" /> -->
        <c:set var="pseudo" scope="page">Robert</c:set>
        <p><c:out value="${ pseudo }"/></p>
        <c:remove var="pseudo" scope="page" />
        
        <c:set target="${ author }" property="firstName" value ="Robert" />
        <p><c:out value="${ author.firstName }"/></p>
        
        <!-- JSTL Condition -->
        <c:if test="${ 50 > 10 }" var="testResult">
        	C'est vrai !
        </c:if>
        <c:choose>
		    <c:when test="${ false }">Du texte 1</c:when>
		    <c:when test="${ true }">Du texte 2</c:when>
		    <c:when test="${ false }">Du texte 3</c:when>
		    <c:otherwise></c:otherwise>
		</c:choose>
		
		<!-- JSTL Loop -->
        <c:forEach var="i" begin="0" end="10" step="2">
		    <p>Un message n°<c:out value="${ i }" /> !</p>
		</c:forEach>
		<c:forEach items="${ names }" var="name" varStatus="status">
		    <p>N°<c:out value="${ status.count }" /> : <c:out value="${ name }" /> !</p>
		</c:forEach>
		<c:forTokens var="morceau" items="Un élément/Encore un autre élément/Un dernier pour la route" delims="/ ">
		    <p>${ morceau }</p>
		</c:forTokens>
        
    </body>
</html>