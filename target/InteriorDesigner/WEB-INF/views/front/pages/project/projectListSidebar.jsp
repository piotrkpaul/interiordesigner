<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav nav-list bs-docs-sidenav"  data-spy="affix" data-offset-top="230">
    <sec:authorize access="isAuthenticated()">
        <li class="important"><a href="${pageContext.request.contextPath}/project/create"><i class="icon-chevron-right"></i> Nowy projekt</a></li>
        <li><a href="${pageContext.request.contextPath}/project/user"><i class="icon-chevron-right"></i> Moje projektów</a></li>
     </sec:authorize>
    <li><a href="${pageContext.request.contextPath}/project"><i class="icon-chevron-right"></i> Katalog projektów</a></li>
    <li><a href="${pageContext.request.contextPath}/catalog"><i class="icon-chevron-right"></i> Meble</a></li>
</ul>

