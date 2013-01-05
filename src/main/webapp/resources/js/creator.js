$(document).ready(function () {

    $(".furnitureItem").draggable({
        snap: true,
        helper: "clone",
        snapTolerance: 2,
        containment: "#projectData",
        revert: "invalid",
        delay: 400
    });

    $("#projectData").droppable({
        accept: ".furnitureItem",
        drop: function(event, ui) {
            var element = $(ui.draggable).clone();

            var x = parseInt(ui.position.left - this.offsetLeft, 10);
            var y = parseInt(ui.position.top - this.offsetTop, 10);
            var width = element[0].getElementsByClassName("width")[0];
            var height = element[0].getElementsByClassName("height")[0];
            var name = element[0].getElementsByClassName("name")[0];

            element.css({
                "position": "absolute",
                "top": y,
                "left": x,
                "width": parseInt(width.innerText/2, 10),
                "height": parseInt(height.innerText/2, 10)
            }).addClass("furniture").removeClass('furnitureItem').draggable({
                    snap: true,
                    snapMode: "outer",
                    snapTolerance: 8,
                    containment: "#projectData"
                });


            //Zeruje zawartość (dane) elementu
            element[0].innerHTML = "";

            $("#projectData").append(element);
        }
    });
});

$(function(){
    $("#creator").overscroll({
        cancelOn: '.no-drag',
        scrollLeft: 1,
        scrollTop: 1
    });
});

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
