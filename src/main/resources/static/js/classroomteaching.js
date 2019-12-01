$(document).ready(function() {
    // 宽度
    $(window).resize(function () {
        var height = $("#navwrap").width();
        if (height <= 200) {
            $("#informationwarp").css({ left: "200px" });
            // console.log("yes");
        } else {
            $("#informationwarp").css({ left: "20%" });
        }
    });
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
                .replace(/[^0-9]/g, "");
            $(this).val(temp_amount);
        } else {
            if (/^0/.test($(this).val())) {
                $(this).val("0");
            } else {
                var temp_amount = $(this)
                    .val()
                    .replace(/\D/g, "");
                $(this).val(temp_amount);
            }
        }
    });
    $(".timenum").on("afterpaste", function() {
        if ($(this).val().length == 1) {
            var temp_amount = $(this)
                .val()
                .replace(/[^0-9]/g, "");
            $(this).val(temp_amount);
        } else {
            if (/^0/.test($(this).val())) {
                $(this).val("0");
            } else {
                var temp_amount = $(this)
                    .val()
                    .replace(/\D/g, "");
                $(this).val(temp_amount);
            }
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
    //   输入新密码验证
    $(".modify").on("click", function() {
        //验证修改密码
        var j=0;
        //验证不能为空
        $(this).parent().siblings().children('.form-control-jub').each(function() {
            var value = $(this).val();
            if (value === "") {
                j++;
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
        //确认密码
        var newpassword=$(this).parent().siblings().children("input[name='newPassword']").val();
        var newpassword2=$(this).parent().siblings().children("input[name='newPassword2']").val();

        if(newpassword===newpassword2){
            $(this)
                .parent()
                .siblings(".notnull")
                .css({ display: "none" });
        }else{
            j++;
            $(this)
                .parent()
                .siblings(".notnull")
                .css({ display: "block" });
        }
        if(j===0){
            return true;
        }else{
            return false;
        }
    });

//    密码输入***
//     var str = ""; //定义一个空变量用来存储密码
//     $(".password").keyup(function() {
//         var value = $(this).val(); //输入的时候获取输入框的值
//         console.log(value);
//         str += value.substr(value.length - 1, 1); //获取最后一个字符加到到str,因为除了最后一个字符，其他的已经为*
//         $(this).val(value.replace(/./g, "*")); //输入框内容全部变为*
//         console.log(str); //str即为输入框的内容
//     });
});
