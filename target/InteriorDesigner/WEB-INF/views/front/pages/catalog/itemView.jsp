<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="download">
    <div class="page-header">
        <h1>${furnitureItem.itemName}<small>${furnitureItem.itemPrice}</small></h1>
    </div>
    <div class="thumbnail">
        <img src="${furnitureItem.itemImageUrl}" class="imageDetailView" />
        <div class="caption captionDetailView">
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