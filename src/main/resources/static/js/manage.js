//tools
var twokuan=function (value) {
    return value<10?"0"+value:value;

}
var timeFormatter=function (value) {

    var da = new Date(value);

    return da.getFullYear() + "-" + twokuan(da.getMonth() + 1) + "-" + twokuan(da.getDate()) + " " + twokuan(da.getHours()) + ":" + twokuan(da.getMinutes()) + ":" + twokuan(da.getSeconds());

}
var timeFormatter2=function (value) {

    var da = new Date(value);

    return da.getFullYear() + "-" + twokuan(da.getMonth() + 1) + "-" + twokuan(da.getDate());

}
//defined
var flashUser=function () {
    $.post("/searchUser",function(res){
        var list=res.data;
        $("#userbody").html("");
        $.each(list,function(idx,user){
            $("#userbody").append("<tr>" +
                "<td>"+user.loginId+"</td>" +
                "<td>"+user.username+"</td>" +
                "<td>"+timeFormatter(user.createTime)+"</td>" +
                "<td>"+timeFormatter(user.updateTime)+"</td>" +
                "<td>" +
                "<button id='eubtn" + user.loginId +"' class='btn btn-xs btn-info' value='Edit' data-toggle='modal' data-target='#EditUser' onclick='edituser(this)'> " +
                "Edit" +
                "</button>&nbsp;" +
                "<button class='btn btn-xs btn-danger' onclick='deluser(this)'>" +
                "Delete" +
                "</button> " +
                "</td>" +
                "</tr>");
        });
    });
};

var flashadvertise = function () {
    $.post("/searchAds",function(res){
        var list=res.data;
        $("#adcount").text(list.length);
        $("#adbody").html("");
        $.each(list,function(idx,ad){
            $("#adbody").append("<tr>\n" +
                "<td>" + ad.userId + "</td>\n" +
                "<td><a href='"+ad.url+"'>" + ad.url + "</a></td>\n" +
                "<td>" + timeFormatter(ad.createTime) + "</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-danger btn-xs\" onclick='delAdvertise("+ad.id+");searchHistory();'>\n" +
                "<span class=\"glyphicon glyphicon-remove\"></span>\n" +
                "</button>\n" +
                "</td>\n" +
                "</tr>");
        });
    });
};

var flashstudents = function () {
    $.post("/searchStudent",function(res){
        var list=res.data;
        $("#stuListBody").html("");
        $.each(list,function(idx,stu){
            $("#stuListBody").append("<tr>\n" +
                "<td>" + timeFormatter(stu.createTime) + "</td>\n" +
                "<td>"+stu.name+"</td>\n" +
                "<td>"+stu.gender+"</td>\n" +
                "<td>"+stu.age+"</td>\n" +
                "<td>"+stu.phone+"</td>\n" +
                "<td>"+stu.email+"</td>\n" +
                "<td>"+stu.college+"</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#Details\" onclick='loadDetails("+stu.id+")'>\n" +
                "More\n" +
                "</button>\n" +
                "</td>\n" +
                "</tr>");
        });
    });
};

var delAdvertise=function (adId) {
    $.post("/delAds", {adId: adId}, function (res) {
        if (res.code!=200) {
            alert(res.msg);
        }
    });
};

function addAdvertise() {
    var url = $("#urlinput").val();
    $.post("/addAds", {url: url}, function (res) {
        if (res.code==200) {
            flashadvertise();
        } else {
            alert(res.code);
        }
    });
}

function edituser(t) {
    var chids =  $(t).closest('td').closest('tr').find("td");
    var userid = chids.eq(0).text();
    var username = chids.eq(1).text();
    var ct = chids.eq(2).text();
    var ut = chids.eq(3).text();
    $("#euid").val(userid);
    $("#eusername").val(username);
    $("#eucreateTime").val(ct);
    $("#euupdateTime").val(ut);
}

function deluser(t) {
    var row = $(t).closest('td').closest('tr');
    var chids =  row.find("td");
    var userid = chids.eq(0).text();
    alert(userid);
    $.post("/delUser", {loginId: userid}, function (res) {
        alert(res.msg);
        if(res.code==200){
            row.remove();
        }
    });
}

function adduser() {
    var loginId = $("#loginId").val();
    var username = $("#username").val();
    var password = $("#upassword").val();
    $.post("/addUser", {loginId: loginId, username: username, password: password, status: 1}, function (res) {
        alert(res.msg);
        if (res.code==200) {
            flashUser();
        }
    });
}

function searchHistory() {
    var sd = $("#hstartd").val();
    var ed = $("#hendd").val();
    $.post("/searchAds", {startDate: sd, endDate: ed}, function (res) {
        var list=res.data;
        $("#searchNum").text(list.length);
        $("#hisbody").html("");
        $.each(list,function(idx,ad){
            $("#hisbody").append("<tr>\n" +
                "<td>" + ad.userId + "</td>\n" +
                "<td><a href='"+ad.url+"'>" + ad.url + "</a></td>\n" +
                "<td>" + timeFormatter(ad.createTime) + "</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-danger btn-xs\" onclick='delAdvertise("+ad.id+");searchHistory();'>\n" +
                "<span class=\"glyphicon glyphicon-remove\"></span>\n" +
                "</button>\n" +
                "</td>\n" +
                "</tr>");
        });

    });
};

var flashStuSource=function () {
    $.post("/getStuSource",function (res) {
        var list=res.data;
        $("#SSselect").html("");
        var nulloption = "<option value=''></option>";
        $("#SSSearchSelect").html(nulloption);
        $("#userSSselect").html(nulloption);

        $("#SSselect").html(nulloption);

        $.each(list,function (idx,ss) {
            var sons=ss.sonStuSources;
            $.each(sons,function (ids,son) {
                var content=ss.stuSource.name+"-"+son.name;
                var inv="<option value='"+content+"'>"+content+"</option>";
               $("#SSselect").append(inv);
               $("#SSSearchSelect").append(inv);
               $("#userSSselect").append(inv);
            });
        });
    });
};

var showtable=function () {
    if($("#SSselect").val()=="Web-College"){
        $("#fankuiTable").css("display","");
    }else{
        $("#fankuiTable").css("display","none");
    }
};

var FBHelper=function (chkname,answer) {
    if(answer==null)return;
    var an=answer.split(',');
    for(var i=0;i<an.length;i++){
        var str=an[i];
        if(str.length>1){
            $("#other1").val(str);
        }else {
            $("input[name='" + chkname + "']").eq(str).prop("checked", "true");
        }
    }
};

var updateFU=function (id, stuId) {
    var edspan=$("#edspan"+id);
    if(edspan.hasClass("glyphicon-edit")){
        edspan.removeClass("glyphicon-edit");
        edspan.addClass("glyphicon-ok");
        $("#ta" + id).attr("disabled",false);
    }else if(edspan.hasClass("glyphicon-ok")) {
        var note = $("#ta" + id).val();
        $.post("/updateFollowUp", {id: id, stuId: stuId, note: note}, function (res) {
            if (res.code == 200) {
                alert("updateFollowUp finished!");
            } else {
                alert(res.code);
            }
        });
        edspan.removeClass("glyphicon-ok");
        edspan.addClass("glyphicon-edit");
        $("#ta" + id).attr("disabled",true);
    } else {
        alert("some error!");
    }
};

var addFU = function (stuId) {
    var note = $("#dtfp1").val();
    $.post("/addFollowUp", {stuId: stuId, note: note}, function (res) {
        if (res.code == 200) {
            alert("Add followup finished!");
            $("#dtfp1").val("");
        } else {
            alert(res.code);
        }
    });
};

var delFU = function (fuId) {
    $.post("/delFollowUp", {fuId: fuId}, function (res) {
        if (res.code == 200) {
            alert("del finished!");
            $("#fufg" + fuId).remove();
        } else {
            alert(res.code);
        }
    });
};

var loadDetails=function (stuId) {
    $.post("/getStudent",{stuId:stuId},function (res) {
        var stu=res.data;
        $("#dtdate").val(timeFormatter(stu.createTime));
        $("#dtname").val(stu.name);
        $("#dtgender").val(stu.gender);
        $("#dtage").val(stu.age);
        $("#dtphonenum").val(stu.phone);
        $("#dtemail").val(stu.email);
        $("#dtcollegename").val(stu.college);
        $("#dtmajor").val(stu.major);
        $("#dtwalkindate").val(timeFormatter2(stu.walkinDate));
        $("#dtqqwechat").val(stu.qqWechat);
        $("#dtmarks").val(stu.marks);
        $("#dtinsit").val(stu.interviewNote);
        $("#SSselect").val(stu.studentSource);
        $("#dtintention").val(stu.intention);
        $("#dtclassification").val(stu.classification);
        $("#edstuId").val(stu.id);
    });
    $.post("/getFeedback",{stuId:stuId},function (res) {
        $("input:checkbox").removeAttr("checked");
        $("input:radio").removeAttr("checked");
       var fback=res.data;
       FBHelper('optionsRadiosinline1',fback.answer1);
       FBHelper('optionsRadiosinline2',fback.answer2);
       FBHelper('optionsRadiosinline3',fback.answer3);
       FBHelper('optionsRadiosinline4',fback.answer4);
       FBHelper('optionsRadiosinline5',fback.answer5);
       FBHelper('optionsRadiosinline6',fback.answer6);
       FBHelper('optionsRadiosinline7',fback.answer7);
    });
    $.post("/searchFollowUp",{stuId:stuId},function (res) {
       var fus=res.data;
       $("#followuplist").html("");
       $.each(fus,function (idx,fu) {
           $("#followuplist").append("" +
               "<div class='form-group' id='fufg"+fu.id+"'>" +
               "<label class='col-sm-2 control-label'>Follow Up:</label> " +
               "<div class='col-sm-8' style='text-align: left;'>" +timeFormatter(fu.createTime)+
               "</div>" +
               "<br/><br/>" +
               "<div class='col-sm-2' align='center'>" +
               "<button class='btn btn-danger btn-xs' onclick='delFU("+fu.id+")'>" +
               "<span class='glyphicon glyphicon-remove' onclick=''></span>" +
               "</button>" +
               "<button class='btn btn-info btn-xs' onclick='updateFU("+fu.id+","+stuId+")' >" +
               "<span id='edspan"+fu.id+"' class='glyphicon glyphicon-edit'></span>" +
               "</button>" +
               "</div>" +
               "<div class='col-sm-10'>" +
               "<textarea id='ta"+fu.id+"' class='form-control' style='width: 96%;resize: none;' rows='4' disabled='true'>"+fu.note+"</textarea>" +
               "</div>" +
               "</div>");

       });
    });
};
//Jquery
$("#submitdt").click(function () {
    //followup
    var stuId=$("#edstuId").val();
    if($.trim($("#dtfp1").val()).length>0){
        addFU(stuId);
    }
    //student
    var name=$("#dtname").val();
    var gender=$("#dtgender").val();
    var age=$("#dtage").val();
    var phone=$("#dtphonenum").val();
    var email=$("#dtemail").val();
    var college=$("#dtcollegename").val();
    var qqWechat=$("#dtqqwechat").val();
    var major=$("#dtmajor").val();
    var walkinDate=$("#dtwalkindate").val();
    var marks=$("#dtmarks").val();
    var insit=$("#dtinsit").val();
    var intention=$("#dtintention").val();
    var classification=$("#dtclassification").val();
    var stusource=$("#stusource").val();
    if($.trim(stusource).length>0){
        $.post("/addStuSource",{pre:stusource.split('-')[0],back:stusource.split('-')[1]},function (res) {
            if(res.code==200){
                flashStuSource();
                $("#stusource").val("");
            }else{
                alert(res.msg);
            }
        });
    }else{
        stusource=$("#SSselect").val();
    }
    $.post("/updateStudent",
        {id:stuId,name:name,gender:gender,age:age,phone:phone,email:email,college:college,major:major,walkingDate:walkinDate,interviewNote:insit,marks:marks,intention:intention,studentSource:stusource,classification:classification,qqWechat:qqWechat},
        function (res) {
            if(res.code!=200){
                alert(res.msg);
            }
    });
    //feedback
});
$("#submiteu").click(function () {
    var formData = new FormData($('#euform')[0]);
    $.ajax({
        type: 'post',
        url: '/updateUser',
        data: formData,
        contentType: false,
        processData: false,
        success: function(res) {
            if (res.code==200) {
                flashUser();
            }else{
                alert(res.msg);
            }
        }
    });
});

$("#urlinput").keydown(function (e) {
    if(e.keyCode==13){
        addAdvertise();
        $("#urlinput").val("");
    }
});

$("#newStudentBtn").click(function () {
    var formData = new FormData($('#newStudentForm')[0]);
    $.ajax({
        type: 'post',
        url: '/addStudent',
        data: formData,
        contentType: false,
        processData: false,
        success: function(res) {
            if (res.code==200) {
                flashstudents();
            }else{
                alert(res.msg);
            }
        }
    });
});

$("#sssearch").click(function () {
    var sd = $("#sssdate").val();
    var ed = $("#ssedate").val();
    var name = $("#ssname").val();
    var clf = $("#selectclass option:selected").val();
    var source = $("#SSSearchSelect option:selected").val();
    $.post("/searchStudent", {name: name, startDate: sd, endDate: ed, classification: clf, source: source}, function (res) {
        if (res.code==200) {
            var list = res.data;
            $("#ssbody").html("");
            $.each(list, function (idx, stu) {
                var name = stu.name;
                var gender = stu.gender;
                var age = stu.age;
                var phone = stu.phone;
                var email = stu.email;
                var college = stu.college;
                var createTime = stu.createTime;
                $("#ssbody").append("<tr>\n" +
                    "<td>" + timeFormatter(createTime) + "</td>\n" +
                    "<td>" + name + "</td>\n" +
                    "<td>" + gender + "</td>\n" +
                    "<td>" + age + "</td>\n" +
                    "<td>" + phone + "</td>\n" +
                    "<td>" + email + "</td>\n" +
                    "<td>" + college + "</td>\n" +
                    "<td>\n" +
                    "<button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#Details\">\n" +
                    "More\n" +
                    "</button>\n" +
                    "</td>\n" +
                    "</tr>");
            });
        }
    });
});

$("#research").click(function () {
    var userId = $("#userSearchUserId").val();
    var startDate = $("#userSearchStartDate").val();
    var endDate = $("#userSearchEndDate").val();
    var classification = $("#rcselect option:selected").val();
    //userSSselect
    var source = $("#userSSselect option:selected").val();
    $.post("/searchCount", {userId: userId, startDate: startDate, endDate: endDate, classification: classification, source: source}, function (res) {
        var count = res.data;
        $("#count").text(count);
    });

});

// $("#submitdt").click(function () {
//     var note = $("#dtfp1").val();
//     $.post("/addFollowUp", {})
// });

//document.ready
flashUser();
flashadvertise();
flashstudents();
flashStuSource();