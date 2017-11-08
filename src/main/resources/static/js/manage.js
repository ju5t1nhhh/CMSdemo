$.post("/searchUser",function(res){
    var list=res.data;
    $("#userbody").html("");
    $.each(list,function(idx,user){
        $("#userbody").append("<tr>" +
            "<td>"+user.loginId+"</td>" +
            "<td>"+user.username+"</td>" +
            "<td>"+user.createTime+"</td>" +
            "<td>"+user.updateTime+"</td>" +
            "<td>" +
            "<button class='btn btn-xs btn-info' value='Edit' data-toggle='modal' data-target='#EditUser'> " +
            "Edit" +
            "</button>&nbsp;" +
            "<button class='btn btn-xs btn-danger' onclick=''>" +
            "Delete" +
            "</button> " +
            "</td>" +
            "</tr>");
    });
});