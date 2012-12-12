<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="itemView">
    <div class="page-header">
        <h1>${furnitureItem.itemName}<small> ${furnitureItem.itemPrice} zł</small></h1>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="${pageContext.request.contextPath}/catalog/delete/${furnitureItem.id}" class="btn btn-danger">Usuń</a>
        </sec:authorize>
    </div>
    <div class="furnitureItemView">
        <img src="${furnitureItem.itemImageUrl}" class="imageDetailView" />
        <div class="itemDescription">
            ${furnitureItem.itemDescription}
        </div>

    <blockquote>
        <p>Szerokość: ${furnitureItem.sizeX}</p>
        <p>Długość: ${furnitureItem.sizeY}</p>
        <p>Wysokość: ${furnitureItem.sizeZ}</p>
        <small>ID obiektu: ${furnitureItem.id}</small>
    </blockquote>
    </div>

</section>