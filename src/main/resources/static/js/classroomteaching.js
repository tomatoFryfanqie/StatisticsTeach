$(document).ready(function() {
    // 失去焦点
    $("input").on("blur", function() {
        if ($(this).val() === "") {
            $(this)
                .parent()
                .next(".warning")
                .css({ display: "block" });
        } else {
            $(this)
                .parent()
                .next(".warning")
                .css({ display: "none" });
        }
    });
    // 输入整数
    $(".timenum").on("keyup", function() {
        if ($(this).val().length == 1) {
            var temp_amount = $(this)
                .val()
                .replace(/[^1-9]/g, "");
            $(this).val(temp_amount);
        } else {
            var temp_amount = $(this)
                .val()
                .replace(/\D/g, "");
            $(this).val(temp_amount);
        }
    });
    $(".timenum").on("afterpaste", function() {
        if ($(this).val().length == 1) {
            var temp_amount = $(this)
                .val()
                .replace(/[^1-9]/g, "");
            $(this).val(temp_amount);
        } else {
            var temp_amount = $(this)
                .val()
                .replace(/\D/g, "");
            $(this).val(temp_amount);
        }
    });
    //  判断输入框不为空
    $(".add").on("click", function() {
        var i=0;
        $(this).parent().siblings().children('.form-control-jub').each(function() {
            var value = $(this).val();
            console.log("hhh"+value);
            if (value === "") {
                i++;
                $(this)
                    .parent()
                    .next(".warning")
                    .css({ display: "block" });
            } else {
                $(this)
                    .parent()
                    .next(".warning")
                    .css({ display: "none" });
            }
        });
        if(i===0){
            return true;
        }else{
            return false;
        }
    });
});
