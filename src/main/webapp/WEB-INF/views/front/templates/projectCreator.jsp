<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertAttribute name="head" />
<tiles:insertAttribute name="navbar" />
<tiles:insertAttribute name="intro" />

<div class="container">
    <c:if test="${!empty param.error}">
        <div class="alert alert-block alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Uwaga!</h4>
            <c:out value="${param.error}"/>
        </div>
    </c:if>
    <c:if test="${!empty param.info}">
        <div class="alert alert-block">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Informacja</h4>
            <c:out value="${param.info}"/>
        </div>
    </c:if>
    <div class="projectCreator">
            <tiles:insertAttribute name="content" />
    </div>
</div>

<tiles:insertAttribute name="bottom" />