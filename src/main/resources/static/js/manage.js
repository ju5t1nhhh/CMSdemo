//tools
var twokuan=function (value) {
    return value<10?"0"+value:value;

}
var timeFormatter=function (value) {

    var da = new Date(value);

    return da.getFullYear() + "-" + twokuan(da.getMonth() + 1) + "-" + twokuan(da.getDate()) + " " + twokuan(da.getHours()) + ":" + twokuan(da.getMinutes()) + ":" + twokuan(da.getSeconds());

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
        $("#stubody").html("");
        $.each(list,function(idx,stu){
            $("#stubody").append("<tr>\n" +
                "<td>" + stu.creatTime + "</td>\n" +
                "<td>Bangalore</td>\n" +
                "<td>560001</td>\n" +
                "<td>Tanmay</td>\n" +
                "<td>Bangalore</td>\n" +
                "<td>560001</td>\n" +
                "<td>Tanmay</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#Details\">\n" +
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
    alert("from deluser");
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
    alert("from adduser");
    var loginId = $("#loginId").val();
    var username = $("#username").val();
    var password = $("#upassword").val();
    alert(loginId + " " + username + " " + password);
    $.post("/addUser", {loginId: loginId, username: username, password: password, status: 1}, function (res) {
        alert(res.msg);
        if (res.code==200) {
            flashUser();
        }
    });
}

function searchHistory() {
    alert("from history");
    var sd = $("#hstartd").val();
    var ed = $("#hendd").val();
    $.post("/searchAds", {startDate: sd, endDate: ed}, function (res) {
        var list=res.data;
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

//Jquery
$("#submiteu").click(function () {
    var formData = new FormData($('#euform')[0]);
    $.ajax({
        type: 'post',
        url: '/updateUser',
        data: formData,
        contentType: false,
        processData: false,
        success: function(res) {
            alert(res.msg);
            if (res.code==200) {
                flashUser();
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

//document.ready
flashUser();
flashadvertise();