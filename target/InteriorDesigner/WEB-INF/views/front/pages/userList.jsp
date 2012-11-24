<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="download" id="components">
    <div class="page-header">
        <a class="btn btn-small pull-right toggle-all" href="#">Toggle all</a>
        <h1>
            1. Choose components
        </h1>
    </div>
    <div class="row download-builder">
        <div class="span3">
            <h3>Scaffolding</h3>
            <ul>
                <c:forEach var="user" items="${userList}">
                    <li>${user.name}</li>
                </c:forEach>
            </ul>
        </div><!-- /span -->
    </div><!-- /row -->
</section>