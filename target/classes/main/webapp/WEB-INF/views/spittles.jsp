<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittles</title>
</head>
<body>
	<c:out value="${spittles}"/>
	<c:choose>
		<c:when test="${not empty spittles}">
		<ol>
			<c:forEach var="spittle" items="${spittles}">
				<li id="<c:out value="spittle_${spittle.id}"/>">
					<div class="spittleMessage"><c:out value="${spittle.message}"/></div>
					<div>
						<span class="spittleTime">
							<c:out value="${spittle.time}"/>
						</span>
						<span class="spittleLocation">
							(<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/> )
						</span>
					</div>
				</li>
			</c:forEach>
		</ol>
		</c:when>
		<c:otherwise>
			<c:out value="No spittles yet!"/>
		</c:otherwise>
	</c:choose>
</body>
</html>