$(document).ready(function() {
    // 宽度
    $(window).resize(function () {
        var height = $("#navwrap").width();
        if (height <= 200) {
            $("#informationwarp").css({ left: "200px" });
        } else {
            $("#informationwarp").css({ left: "20%" });
        }
    });
});