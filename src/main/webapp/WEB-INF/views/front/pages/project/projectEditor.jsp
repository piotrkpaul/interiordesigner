<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sf:form method="post" class="form-projectData" commandName="projectDataEntity">
    <sf:errors path="title" cssClass="alert alert-error" element="div"/>
    <p class="lead">Tytuł projektu</p>
    <sf:input path="title" min="3" maxlength="120" id="project_title" class="input-block-level" placeholder="Tytuł"/>
    <p class="lead">Opis projektu</p>
    <sf:textarea path="projectDescription" min="1" max="4000" id="project_description" class=""
                 placeholder="Opisz swój projekt"/>
    <br/>

    <div class="form-actions">
        <div class="btn-group">
            <a class="btn btn-success btn-small items-tab" id="addFurnitureItem" data-toggle="modal" href="#furnitureItemList"><i
                    class="icon-plus icon-white"></i> Dodaj mebel</a>
            <input type="submit" class="btn btn-primary btn-small" value="Zapisz"/>
            <a href="${pageContext.request.contextPath}/project" class="btn btn-small btn-inverse">Powrót</a>
        </div>
    </div>
    <div id="creator">
        <div id="projectDataViewer">
                ${furnitureHtml}
                ${wallsHtml}
        </div>
    </div>
</sf:form>

<div id="furnitureItemList" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Dodaj mebel do projektu</h3>
        <ul class="nav nav-tabs">
            <li class="active"><a href="#wardrobes" class="items-tab" data-toggle="tab">Szafy</a></li>
            <li><a href="#chairs" class="items-tab" data-toggle="tab">Krzesła</a></li>
            <li><a href="#tables" class="items-tab" data-toggle="tab">Stoły</a></li>
            <li><a href="#sofas" class="items-tab" data-toggle="tab">Sofy i fotele</a></li>
            <li><a href="#beds" class="items-tab" data-toggle="tab">Łóżka</a></li>
            <li><a href="#dresser" class="items-tab" data-toggle="tab">Komody</a></li>
            <li><a href="#agd" class="items-tab" data-toggle="tab">AGD</a></li>
            <li><a href="#cabinet" class="items-tab" data-toggle="tab">Szafki</a></li>
        </ul>
    </div>
    <div class="modal-body">
        <div class="tabbable"> <!-- Only required for left/right tabs -->
            <div class="tab-content">
                <div class="tab-pane active" id="wardrobes"></div>
                <div class="tab-pane" id="chairs"></div>
                <div class="tab-pane" id="tables"></div>
                <div class="tab-pane" id="sofas"></div>
                <div class="tab-pane" id="beds"></div>
                <div class="tab-pane" id="agd"></div>
                <div class="tab-pane" id="dresser"></div>
                <div class="tab-pane" id="cabinet"></div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-primary">Save changes</button>
    </div>
</div>

<script>
    $(function(){
      $(document).on('click', '.items-tab', function(){
        var _this = $(this);
        var itemsCategory = _this.attr("href").replace("#", "");
          if(itemsCategory == "furnitureItemList") {
              itemsCategory = "wardrobes";
          }
        if($("#" + itemsCategory).html() == "") {
          $.ajax({
              type:"GET",
              url:"../../catalog/category/" + itemsCategory
          }).done(function (msg) {
                      var furnitureData = JSON.parse(msg);
                      var htmlCode = '<ul class="f_itemList">';
                      jQuery.each(furnitureData, function(i, val) {
                          htmlCode +=  '<li class="f_item"><span class="f_item-name">' + val.itemName +
                                       '</span><span class="f_item-id">' + val.id +
                                       '</span><div class="f_item-size">Rozmiar: <span class="f_item-width">' + val.sizeX +
                                       '</span> cm x <span class="f_item-height">' + val.sizeY +
                                       '</span> cm</div><span class="f_item-price">' + val.itemPrice +
                                       '</span>zł<br /><span class="f_item-image"><img src="' + val.itemImageUrl + '" />' +
                                       '</span></li>';
                      });

                      htmlCode+="</ul>";
                      $("#" + itemsCategory).append(htmlCode);
          });
        } else {
            console.log("Already on list");
        }
      });

      $(document).on('click', ".f_item", function() {
          var p = $(this);
          console.log($(this).children(".f_id"));
          var chosenFurniture = "<div class='furniture movable obstacle just-added' style='position:absolute; width:"
                + $(this).children(".f_item-size").children(".f_item-height").text() + "px; height:"
                + $(this).children(".f_item-size").children(".f_item-width").text() + "px; top: 100px; left: 150px;'>"
                + "<span class='f_id'>" + $(this).children(".f_item-id").text() + "</span>"
                + "<span class='f_width'>" + $(this).children(".f_item-size").children(".f_item-width").text()  + " cm</span>"
                + "<span class='f_height'>" + $(this).children(".f_item-size").children(".f_item-height").text() + " cm</span>"
                + "<div class='f_delete'></div>"
                + "<div class='f_rotate'></div>"
                + "</div>";
          $("#projectDataViewer").append(chosenFurniture)
          $(".just-added").draggable({ containment: "#projectDataViewer", obstacle: ".obstacle", preventCollision: true }).removeClass("just-added");
          chosenFurniture = null;
          $('#furnitureItemList').modal('hide')
      });

        $(document).on('click', '.f_delete', function(){
           $(this).parent('.furniture').remove();
        });
        $(document).on('click', '.f_rotate', function(){
            console.log("klick" + $(this));
            var _this = $(this);
            var _parent = _this.parent('.furniture');
            var width = _parent.css('width');
            var height = _parent.css('height');

                _parent.css('width', height);
                _parent.css('height', width);

            _parent.children('.f_width').html(height);
            _parent.children('.f_height').html(width);

            _this.remove();
            _parent.append("<div class='f_rotate new'></div>");
        });
    });
</script>