//tools
// $.extend({
//     myTime:{
//         CurTime: function(){
//             return Date.parse(new Date())/1000;
//         },
//         DateToUnix: function(string) {
//             var f = string.split(' ', 2);
//             var d = (f[0] ? f[0] : '').split('-', 3);
//             var t = (f[1] ? f[1] : '').split(':', 3);
//             return (new Date(
//                 parseInt(d[0], 10) || null,
//                 (parseInt(d[1], 10) || 1) - 1,
//                 parseInt(d[2], 10) || null,
//                 parseInt(t[0], 10) || null,
//                 parseInt(t[1], 10) || null,
//                 parseInt(t[2], 10) || null
//             )).getTime() / 1000;
//         },
//         UnixToDate: function(unixTime, isFull, timeZone) {
//             if (typeof (timeZone) == 'number'){
//                 unixTime = parseInt(unixTime) + parseInt(timeZone) * 60 * 60;
//             }
//             var time = new Date(unixTime * 1000);
//             var ymdhis = "";
//             ymdhis += time.getUTCFullYear() + "-";
//             ymdhis += (time.getUTCMonth()+1) + "-";
//             ymdhis += time.getUTCDate();
//             if (isFull === true){
//                 ymdhis += "" + time.getUTCHours() + ":";
//                 ymdhis += time.getUTCMinutes() + ":";
//                 ymdhis += time.getUTCSeconds();
//             }
//             return ymdhis;
//         }
//     }
// });
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
        if(res.code==200){
            alert(res.msg);
            row.remove();
        }else{
            alert(res.msg);
        }
    });
}

$("#submiteu").click(function () {
    var formData = new FormData($('#euform')[0]);
    $.ajax({
        type: 'post',
        url: '/updateUser',
        data: formData,
        contentType: false,
        processData: false,
        success: function(res) {
               if(res.code==200){
                   alert(res.msg);
                   flashUser();
               }else{
                   alert(res.msg);
               }
        }
    });
});

//document.ready
flashUser();
