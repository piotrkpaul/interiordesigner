/* $(function(){
 $("#creator").overscroll({
 cancelOn: '.furniture',
 scrollLeft: 1,
 scrollTop: 1
 });
 });*/

//Opis przedmiotu
$(document).on('click', '.furniture', function (event) {
    var id = $(this).find(".f_id")[0].innerText;
    var furniture = $(this);
    if (furniture.attr("data-original-title") == null) {
        $.ajax({
            type:"POST",
            url:"../catalog/" + id
        }).done(function (msg) {
                var furnitureData = JSON.parse(msg);
                var itemDetails = '<img src="' + furnitureData.itemImageUrl + '" />' +
                    '<b>ID: </b>' + furnitureData.id +
                    '<br /><b>Kategoria: </b>' + furnitureData.itemCategory +
                    '<br /><b>Cena: </b>' + furnitureData.itemPrice + ' zł<br />';

                furniture.attr("data-original-title", furnitureData.itemName);

                furniture.attr("data-content", itemDetails + furnitureData.itemDescription);
                furniture.clickover({ html:true}).clickover();
            });
    }
});


$(function () {

    var zoomSize = 3;

    $(".movable").draggable({ containment:"#projectDataViewer", obstacle:".obstacle", preventCollision:true });

    $(document).on('mousedown', '.movable', function (e) {
        $(this).removeClass('obstacle');
    });
    $(document).on('mouseup', '.movable', function (e) {
        $(this).addClass('obstacle');
    });

    $(document).on('click', ".zoomButton", function (e) {

        var _this = $(this);
        var _actionTrigger = _this.attr("id");

        var multiplier = -1;

        if (_actionTrigger == "zoomOut") {
            if(zoomSize > 3 ) {
                multiplier = 0.5;
                zoomSize--;
            }
        } else if (_actionTrigger == "zoomIn") {
            if(zoomSize < 5 ) {
                multiplier = 2;
                zoomSize++;
            }
        } else if (_actionTrigger == "normalSize") {
            var delta = 3 - zoomSize;
            if (delta < 0) {
                multiplier = (1/2)/(delta * (-1));
                zoomSize = 3;
            } else if (delta > 0) {
                multiplier = delta * 2;
                zoomSize = 3;
            } else {
                multiplier = -1;
            }
        }

        if (zoomSize <= 5 && zoomSize >= 3 && multiplier != -1) {

            //Changing size of project area
            var areaX = $("#projectDataViewer").css('width').replace("px", "");
            var areaY = $("#projectDataViewer").css('height').replace("px", "");

            $("#projectDataViewer").css('width', parseInt(areaX * multiplier, 10) + "px");
            $("#projectDataViewer").css('height', parseInt(areaY * multiplier, 10) + "px");

            var _elements = $("#projectDataViewer").children("div");
            $.each(_elements, function () {

                //Changing size and location of each of furniture and wall item
                var obj = $(this);

                var _width = obj.css("width").replace("px", "");
                var _height = obj.css("height").replace("px", "");
                var _x = obj.css("left").replace("px", "");
                var _y = obj.css("top").replace("px", "");

                // For every wall item, we change only one dimmension
                if(obj.hasClass('wall')) {
                    if(parseInt(_width, 10) < parseInt(_height, 10) ) {
                        obj.css("height", parseInt(_height * multiplier, 10) + "px");
                        if (multiplier != 2) {
                            if (_actionTrigger == "normalSize") {
                                obj.css("width", "3px");
                            } else {
                                obj.css("width", parseInt(_width, 10)-1 + "px");
                            }
                        } else {
                           obj.css("width", parseInt(_width, 10)+1 + "px");
                        }
                    } else {
                        obj.css("width", parseInt(_width * multiplier, 10) + "px");
                        if (multiplier != 2) {
                            if (_actionTrigger == "normalSize") {
                                obj.css("height", "3px");
                            } else {
                                obj.css("height", parseInt(_height, 10)-1 + "px");
                            }
                        } else {
                            obj.css("height", parseInt(_height, 10)+1 + "px");
                        }
                    }
                } else {
                    obj.css("width", parseInt(_width * multiplier, 10) + "px");
                    obj.css("height", parseInt(_height * multiplier, 10) + "px");
                }
                obj.css("left", parseInt(_x * multiplier, 10) + "px");
                obj.css("top", parseInt(_y * multiplier, 10) + "px");
            });
        }
    });

    $("#projectDataEntity").submit(function (e) {
        var furnitureList = [];
        $(".furniture").each(function (index) {
            furnitureList.push(new furnitureItem(
                $(this).find(".f_id")[0].innerText,
                $(this).css('left').replace('px', ''),
                $(this).css('top').replace('px', ''),
                $(this).css('width').replace('px', ''),
                $(this).css('height').replace('px', ''))
            );
        });

        var wallList = [];
        $(".wall").each(function (index) {
            var x2 = parseInt($(this).css('left').replace('px', ''), 10) + parseInt($(this).css('width').replace('px', ''), 10);
            var y2 = parseInt($(this).css('top').replace('px', ''), 10) + parseInt($(this).css('height').replace('px', ''), 10);
            wallList.push(new wallItem(
                $(this).css('left').replace('px', ''),
                $(this).css('top').replace('px', ''),
                x2,
                y2)
            );
        });


        var furnitureListJSON = JSON.stringify(furnitureList);

        $('<input />').attr('type', 'hidden')
            .attr('name', 'dataObjects')
            .attr('value', furnitureListJSON)
            .appendTo('#projectDataEntity');


        var wallListJSON = JSON.stringify(wallList);

        $('<input />').attr('type', 'hidden')
            .attr('name', 'dataWalls')
            .attr('value', wallListJSON)
            .appendTo('#projectDataEntity');

    });

    function furnitureItem(id, x, y, width, height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    function wallItem(x1, y1, x2, y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

});

