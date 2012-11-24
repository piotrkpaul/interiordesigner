<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tiles:insertAttribute name="head" />
<tiles:insertAttribute name="navbar" />
<tiles:insertAttribute name="intro" />

<div class="container">
    <div class="row">
        <div class="span3 bs-docs-sidebar">
            <tiles:insertAttribute name="sidebar" />
        </div>

        <div class="span9">
            <tiles:insertAttribute name="content" />
        </div>
    </div>
</div>

<tiles:insertAttribute name="bottom" />