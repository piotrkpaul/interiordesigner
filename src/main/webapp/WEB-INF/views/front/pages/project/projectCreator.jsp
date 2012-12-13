<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form method="post" class="form-projectData" commandName="projectDataEntity">
    <sf:errors path="title" cssClass="alert alert-error" element="div" />
    <sf:input path="title" min="3" maxlength="120" id="project_title" class="input-block-level" placeholder="Tytuł"/>

    <sf:textarea path="projectDescription" min="1" max="4000" id="project_description" class="" placeholder="Opisz swój projekt" />

    <div id="creator">
        <div id="projectData">
        </div>
        <div id="objectList">
            <div id="bed-item" class="item"></div>
        </div>
    </div>

    <div class="form-actions">
        <input type="submit" class="btn btn-primary" value="Zapisz" />
        <a href="${pageContext.request.contextPath}/project" class="btn">Powrót</a>
    </div>

</sf:form>