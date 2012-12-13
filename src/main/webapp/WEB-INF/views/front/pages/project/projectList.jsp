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
                    <div class="projectDesc">
                        ${p.projectDescription}
                    </div>
                    <div class="btn-group">
                        <a class="btn btn-small btn-primary" href="${pageContext.request.contextPath}/project/${p.id}">Otwórz</a>
                        <c:if test="${principal == p.ownerId}">
                            <a class="btn btn-small btn-success" href="${pageContext.request.contextPath}/project/edit/${p.id}">Edytuj</a>
                            <a class="btn btn-small btn-danger" href="${pageContext.request.contextPath}/project/delete/${p.id}">Usuń</a>
                        </c:if>
                     </div>

                </p>
            </div>
        </c:forEach>
</section>
