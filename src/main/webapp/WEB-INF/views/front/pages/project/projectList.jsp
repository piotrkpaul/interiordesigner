<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="download" id="wardrobes">
    <div class="page-header">
        <h1>
           Lista projektów
        </h1>
    </div>
    <div id="accordion">
        <c:forEach var="p" items="${projectList}">
            <h3>${p.title}</h3>
            <div>
                <p>
                    ${p.projectDescription}
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/project/${p.id}">Otwórz</a>
                    <c:choose>
                        <c:when test="${pageContext['request'].userPrincipal} == ${p.ownerId}">
                            <a class="btn btn-success" href="${pageContext.request.contextPath}/project/edit/${p.id}">Edytuj</a>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/project/delete/${p.id}">Usuń</a>
                        </c:when>
                    </c:choose>
                </p>
            </div>
        </c:forEach>
</section>
