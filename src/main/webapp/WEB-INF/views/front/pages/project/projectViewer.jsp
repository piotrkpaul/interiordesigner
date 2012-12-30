<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p class="lead">
    Dane projektu:
</p>
<blockquote>
    <p>${description}</p>
    <small>Stworzono: ${projectDataEntity.dateOfCreation}</small>
    <small>Ostatnia edycja: ${projectDataEntity.dateOfLastEdit}</small>
</blockquote>

<div id="creator">
    <div id="projectDataViewer">
        ${furnitureHtml}
    </div>
</div>


<script type="text/javascript">
    $(document).on('click', '.furniture', function (event) {
        var id = $(this).text();
        var furniture = $(this);
        if (furniture.attr("data-original-title") == null) {
            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/catalog/" + id
            }).done(function (msg) {
                        var furnitureData = JSON.parse(msg);
                        var itemDetails = '<img src="' + furnitureData.itemImageUrl + '" />' +
                                          '<b>ID: </b>' + furnitureData.id +
                                          '<br /><b>Kategoria: </b>' + furnitureData.itemCategory +
                                          '<br /><b>Cena: </b>' + furnitureData.itemPrice + ' zł<br />';

                        furniture.attr("data-original-title", furnitureData.itemName);

                        furniture.attr("data-content", itemDetails + furnitureData.itemDescription);
                        furniture.popover({ html:true}).popover('show');
                    });
        }
    });
</script>