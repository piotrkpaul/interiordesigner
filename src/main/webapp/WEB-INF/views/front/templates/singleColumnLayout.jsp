<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertAttribute name="head" />
<tiles:insertAttribute name="navbar" />
<div class="container">
    <tiles:insertAttribute name="content" />
</div>
<tiles:insertAttribute name="bottom" />