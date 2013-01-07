/* $(function(){
    $("#creator").overscroll({
        cancelOn: '.furniture',
        scrollLeft: 1,
        scrollTop: 1
    });
});*/

//Opis przedmiotu
$(document).on('click', '.furniture', function (event) {
    var id = $(this).text();
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

$(function() {

    $(".movable").draggable({ containment: "#projectDataViewer", obstacle: ".obstacle", preventCollision: true });

    $('.movable').on('mousedown', function(e) {
        $(this).removeClass('obstacle');
    });
    $('.movable').on('mouseup', function(e) {
        $(this).addClass('obstacle');
    });

    $("#projectDataEntity").submit(function(e){
        var furnitureList = [];
        $(".furniture").each(function(index){
            furnitureList.push(new furnitureItem(
                $(this).text(),
                $(this).css('left').replace('px', ''),
                $(this).css('top').replace('px', ''),
                $(this).css('width').replace('px', ''),
                $(this).css('height').replace('px', ''))
            );
        });

        var wallList = [];
        $(".wall").each(function(index){
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

    function furnitureItem(id, x, y, width, height){
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    function wallItem(x1, y1, x2, y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

});

