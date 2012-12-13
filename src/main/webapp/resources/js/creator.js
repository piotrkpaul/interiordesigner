$(document).ready(function () {
    $("#bed-item").draggable({
        snap: true,
        helper: "clone",
        snapTolerance: 2,
        containment: "#projectData",
        revert: "invalid",
        delay: 400
    });

    $("#projectData").droppable({
        accept: ".item",
        drop: function(event, ui) {
            var element = $(ui.draggable).clone();
            var x = parseInt(ui.position.left - this.offsetLeft, 10);
            var y = parseInt(ui.position.top - this.offsetTop, 10);

            element.css({
                "position": "absolute",
                "top": y,
                "left": x
            }).addClass("furniture").removeClass('item').draggable({
                    snap: true,
                    snapMode: "outer",
                    snapTolerance: 8,
                    containment: "#projectData"
                });

            $("#projectData").append(element);
        }
    });
});