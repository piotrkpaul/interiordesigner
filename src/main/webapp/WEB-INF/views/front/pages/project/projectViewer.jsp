<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p class="lead">
    Dane projektu:
</p>
<blockquote>
    <p>${description}</p>
    <small>Stworzono: ${projectDataEntity.dateOfCreation}</small>
    <small>Ostatnia edycja: ${projectDataEntity.dateOfLastEdit}</small>
</blockquote>
<c:if test="${principal == p.ownerId}">
    <div class="form-actions">
        <a class="btn btn-small btn-success" href="${pageContext.request.contextPath}/project/edit/${projectDataEntity.id}">Edytuj</a>
        <a class="btn btn-small btn-danger" href="${pageContext.request.contextPath}/project/delete/${projectDataEntity.id}">Usuń</a>
    </div>
</c:if>
<div id="creator">
    <div id="projectDataViewer">
        ${furnitureHtml}
        ${wallsHtml}
    </div>
</div>