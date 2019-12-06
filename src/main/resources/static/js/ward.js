$(document).ready(function() {
//    1.本科生教学竞赛获奖
        $(".addguide").on("click", function() {
            var i=0;
            $(this).parent().siblings().children('.form-control-jub').each(function() {
                var value = $(this).val();
                // console.log("hhh"+value);
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
                var contestName = $("#contestName").val();
                var competition = $("#competition").val();
                var contestLevel = $("#contestLevel").val();
                var studentNum = $("#studentNum").val();
                $.ajax({
                    type: 'POST',
                    url: "/addCompetition",
                    data: {
                        contestName: contestName,
                        competition: competition,
                        contestLevel: contestLevel,
                        studentNum: studentNum
                    },
                    success: function (data) {
                        location.reload(true);
                    },
                    error: function (data) {
                        location.reload(true);
                    }
                });
            }else{
                return false;
            }
        });
//      2.教师教学能力竞赛获奖
    $(".addability").on("click", function() {
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
            var teacherCompetitionName = $("#teacherCompetitionName").val();
            var teacherCompetitioncategory = $("#teacherCompetitioncategory").val();
            var teacherCompetitionform = $("#teacherCompetitionform").val();
            $.ajax({
                type: 'POST',
                url: "/addTeacherCompetition",
                data: {
                    teacherCompetitionName: teacherCompetitionName,
                    teacherCompetitioncategory: teacherCompetitioncategory,
                    teacherCompetitionform: teacherCompetitionform
                },
                success: function (data) {
                    location.reload(true);
                },
                error: function (data) {
                    location.reload(true);
                }
             });
            }else{
            return false;
        }
    });

//      3.指导研究生竞赛获奖
    $(".addpostgraduate").on("click", function() {
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
            var contestName = $("#contestName").val();
            var competition = $("#competition").val();
            var contestLevel = $("#contestLevel").val();
            var studentNum = $("#studentNum").val();
            $.ajax({
                type: 'POST',
                url: "/addMasterCompetition",
                data:{
                    contestName: contestName,
                    competition: competition,
                    contestLevel: contestLevel,
                    studentNum: studentNum
                },
                success: function(data){
                    location.reload(true);
                },
                error : function(data) {
                    location.reload(true);
                }
            });
        }else{
            return false;
        }
    });
    //      4.审核
    $(".addoffice").on("click", function() {
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
            return  true;
            var gh = $("#gh").val();
            var name = $("#name").val();
            var type = $("#type").val();
            $.ajax({
                type: 'POST',
                url: "/addUser",
                data:{
                    gh: gh,
                    name: name,
                    type: type
                },
                success: function(data){
                    location.reload(true);
                    alert(data);
                },
                error : function(data) {
                    location.reload(true);
                }
            });
        }else{
            return false;
        }
    });
//      5.审核
    $(".adddepartment").on("click", function() {
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
            var department = $("#department").val();
            var gh = $("#gh").val();
            var name = $("#name").val();
            var type = $("#type").val();
            $.ajax({
                type: 'POST',
                url: "/addOfficeUser",
                data:{
                    department: department,
                    gh: gh,
                    name: name,
                    type: type
                },
                success: function(data){
                    location.reload(true);
                    alert(data);
                },
                error : function(data) {
                    location.reload(true);
                }
            });
        }else{
            return false;
        }
    });
});