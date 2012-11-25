<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="download" id="wardrobes">
    <div class="page-header">
        <h1>
            1. Szafy
        </h1>
    </div>
    <div class="row download-builder">
            <ul class="furnitureItemList">
                <c:forEach var="item" items="${wardrobes}">
                        <li class="span4">
                            <div class="thumbnail">
                                <img src="${item.itemImageUrl}" />
                                <div class="caption">
                                    <h3>${item.itemName}</h3>
                                    <p>${item.itemPrice} zł</p>
                                    <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                                </div>
                            </div>
                        </li>
                </c:forEach>
            </ul>
    </div>
</section>

<section class="download" id="beds">
    <div class="page-header">
        <h1>
            2. Łóżka
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${beds}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>


<section class="download" id="sofas">
    <div class="page-header">
        <h1>
            3. Sofy i fotele
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${sofas}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<section class="download" id="cabinets">
    <div class="page-header">
        <h1>
            4. Szafki
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${cabinet}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<section class="download" id="chairs">
    <div class="page-header">
        <h1>
            5. Krzesła
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${chairs}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>

<section class="download" id="dressers">
    <div class="page-header">
        <h1>
            6. Komody
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${dresser}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>


<section class="download" id="tables">
    <div class="page-header">
        <h1>
            7. Stoły
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${tables}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>


<section class="download" id="sofas">
    <div class="page-header">
        <h1>
            8. AGD
        </h1>
    </div>
    <div class="row download-builder">
        <ul class="furnitureItemList">
            <c:forEach var="item" items="${agd}">
                <li class="span4">
                    <div class="thumbnail">
                        <img src="${item.itemImageUrl}" />
                        <div class="caption">
                            <h3>${item.itemName}</h3>
                            <p>${item.itemPrice} zł</p>
                            <p><a href="${pageContext.request.contextPath}/catalog/${item.id}" class="btn">Więcej</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>