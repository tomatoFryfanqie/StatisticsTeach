/*$(document).ready(function() {
    var str = ""; //定义一个空变量用来存储密码
    $("input").keyup(function() {
        var value = $(this).val(); //输入的时候获取输入框的值
        str += value.substr(value.length - 1, 1); //获取最后一个字符加到到str,因为除了最后一个字符，其他的已经为*
        $(this).val(value.replace(/./g, "*")); //输入框内容全部变为*
    });
});*/
