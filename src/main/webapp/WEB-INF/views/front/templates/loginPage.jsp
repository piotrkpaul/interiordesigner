<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertAttribute name="head" />
<div class="container" style="width: 385px;">
    <c:if test="${!empty param.error}">
        <div class="alert alert-block alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Uwaga!</h4>
            Błędne dane logowania!
        </div>
    </c:if>
</div>
<tiles:insertAttribute name="content" />