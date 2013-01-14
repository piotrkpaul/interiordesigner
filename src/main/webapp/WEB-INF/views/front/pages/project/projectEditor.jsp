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
        <div class="left">
            <a class="btn btn-success btn-small items-tab" id="addFurnitureItem" data-toggle="modal" href="#furnitureItemList"><i
                    class="icon-plus icon-white"></i> Dodaj mebel</a>
            <a href="#" class="btn btn-small" id="createWall"><i class="icon-minus icon-whte"></i> Dodaj ścianę</a>

            <div class="btn-group">
                <button type="button" class="btn btn-small btn-primary zoomButton" id="zoomOut"><i class="icon-resize-small icon-white"></i>Oddal</button>
                <button type="button" class="btn btn-small btn-primary zoomButton" id="normalSize">100%</button>
                <button type="button" class="btn btn-small btn-primary zoomButton" id="zoomIn"><i class="icon-resize-full icon-white"></i>Powiększ</button>

            </div>
        </div>
        <div class="right">
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
                <div class="tab-pane active" id="wardrobes">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="chairs">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="tables">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="sofas">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="beds">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="agd">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="dresser">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
                <div class="tab-pane" id="cabinet">
                    <div class="listLoadingActivity">Proszę czekać, trwa ładowanie <img src="${pageContext.request.contextPath}/resources/img/ActivityIndicator.gif" class="activityIndicator" /></div>
                </div>
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
        if($("#" + itemsCategory).children(".listLoadingActivity").length) {
          $.ajax({
              type:"GET",
              url:"${pageContext.request.contextPath}/catalog/category/" + itemsCategory
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
                      $("#" + itemsCategory).children(".listLoadingActivity").remove();
                      $("#" + itemsCategory).append(htmlCode);
          });
        }
      });
        $(document).on('click', ".f_item", function() {
          var p = $(this);
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

        $(document).on('click', '#createWall', function(e){

            var _this = $(this);
            var _projectArea = $("#projectDataViewer");
            var clickCounter = 0;
            var x1, x2, y1, y2 = 0;

            _projectArea.addClass("createWallMode");

            if(clickCounter < 2) {
                $(document).on('click', '#projectDataViewer', function(event){
                    clickCounter++;
                    var _event_click = event;
                    if(clickCounter == 1) {
                        x1 = event.pageX - $(this).offset().left;
                        y1 = event.pageY - $(this).offset().top;

                        var wall = "<div class='wall editable obstacle currently' style='position:absolute; top:" + y1 + "px; left:" + x1 + "px;'><span class='wall-height'></span></div>";

                        var i=0;
                        $("#projectDataViewer").append(wall);

                        var _this_wall = $("#projectDataViewer .currently");

                        $("#projectDataViewer").on('mousemove', function(event) {
                            var _event_move = event;
                            var _delta_x = event.pageX - $(this).offset().left - x1;
                            var _delta_y = event.pageY - $(this).offset().top - y1;

                            if(clickCounter == 2) {
                                x2 = event.pageX - $(this).offset().left;
                                y2 = event.pageY - $(this).offset().top;

                                var _wall_width = Math.abs(Math.max(x1,x2) - Math.min(x1,x2));
                                var _wall_height = Math.abs(Math.max(y1,y2) - Math.min(y1,y2));
                                var _wall_top = Math.min(y1,y2);
                                var _wall_left = Math.min(x1,x2);

                                if(_wall_width < _wall_height){
                                    _this_wall.css("top", _wall_top).css("left", _wall_left).css("height", _wall_height).css("width", 3);
                                } else {
                                    _this_wall.css("top", _wall_top).css("left", _wall_left).css("width", _wall_width).css("height", 3);
                                }

                                $("#projectDataViewer").removeClass("createWallMode");
                                _this_wall.removeClass('currently');
                                $("#projectDataViewer").off();

                            }

                            if (Math.abs(_delta_x) > Math.abs(_delta_y)) {
                                _this_wall.children('span').addClass("wall-width").removeClass("wall-height");
                                _this_wall.css("top", y1).css("height", 3);
                                if(_delta_x<0) {
                                    _this_wall.css("left", event.pageX - $(this).offset().left).css("width", x1 - (event.pageX - $(this).offset().left));
                                    _this_wall.children('span').text(x1 - (event.pageX - $(this).offset().left) + " cm");
                                } else {
                                    _this_wall.css("left", x1).css("width", _delta_x);
                                    _this_wall.children('span').text(_delta_x + " cm");
                                }
                            } else {
                                _this_wall.children('span').addClass("wall-height").removeClass("wall-width");
                                _this_wall.css("left", x1).css("width", 3);
                                if(_delta_y<0) {
                                    _this_wall.css("top", event.pageY - $(this).offset().top).css("height", y1 - (event.pageY - $(this).offset().top));
                                    _this_wall.children('span').text(y1 - (event.pageY - $(this).offset().top) + " cm");
                                } else {
                                    _this_wall.css("top", y1).css("height", _delta_y);
                                    _this_wall.children('span').text(_delta_y + " cm");
                                }
                            }
                        });
                    }
                });
            }
            e.preventDefault();
        });
        $(document).on('click', '.f_delete', function(){
           $(this).parent('.furniture').remove();
        });
        $(document).on('click', '.f_rotate', function(){
            var _this = $(this);
            var _parent = _this.parent('.furniture');
            var width = _parent.css('width');
            var height = _parent.css('height');

                _parent.css('width', height);
                _parent.css('height', width);

            _parent.children('.f_width').html(height);
            _parent.children('.f_height').html(width);
        });
    });
</script>