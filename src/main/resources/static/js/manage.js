//tools
var twokuan = function (value) {
    return value < 10 ? "0" + value : value;

}
var timeFormatter = function (value) {

    var da = new Date(value);

    return da.getFullYear() + "-" + twokuan(da.getMonth() + 1) + "-" + twokuan(da.getDate()) + " " + twokuan(da.getHours()) + ":" + twokuan(da.getMinutes()) + ":" + twokuan(da.getSeconds());

}
var timeFormatter2 = function (value) {

    var da = new Date(value);

    return da.getFullYear() + "-" + twokuan(da.getMonth() + 1) + "-" + twokuan(da.getDate());

}
//defined
var flashUser = function () {
    $.post("/searchUser", function (res) {
        var list = res.data;
        $("#userbody").html("");
        $.each(list, function (idx, user) {
            $("#userbody").append("<tr>" +
                "<td>" + user.loginId + "</td>" +
                "<td>" + user.role + "</td>" +
                "<td>" + timeFormatter(user.createTime) + "</td>" +
                "<td>" + timeFormatter(user.updateTime) + "</td>" +
                "<td>" +
                "<button id='eubtn" + user.loginId + "' class='btn btn-xs btn-info' value='Edit' data-toggle='modal' data-target='#EditUser' onclick='edituser(this)'> " +
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
    $.post("/searchAds", function (res) {
        var list = res.data;
        $("#adcount").text(list.length);
        $("#adbody").empty();
        $.each(list, function (idx, ad) {
            $("#adbody").append("<tr>\n" +
                "<td>" + ad.userId + "</td>\n" +
                "<td><a href='" + ad.url + "'>" + ad.url + "</a></td>\n" +
                "<td>" + timeFormatter(ad.createTime) + "</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-danger btn-xs\" onclick='delAdvertise(" + ad.id + ");searchHistory();'>\n" +
                "<span class=\"glyphicon glyphicon-remove\"></span>\n" +
                "</button>\n" +
                "</td>\n" +
                "</tr>");
        });
    });
};
var delStudent = function (stuId) {
    $.post("/delStudent", {stuId: stuId}, function (res) {
        if (res.code == 200) {
            flashstudents();
        } else {
            alert(res.msg);
        }
    });
};
var flashstudents = function () {
    $.post("/searchStudent", function (res) {
        var list = res.data;
        $("#stuListBody").html("");
        $.each(list, function (idx, stu) {
            $("#stuListBody").append("<tr>\n" +
                "<td>" + stu.writerId + "</td>\n" +
                "<td>" + timeFormatter(stu.createTime) + "</td>\n" +
                "<td>" + stu.name + "</td>\n" +
                "<td>" + stu.gender + "</td>\n" +
                "<td>" + stu.age + "</td>\n" +
                "<td>" + stu.phone + "</td>\n" +
                "<td>" + stu.email + "</td>\n" +
                "<td>" + stu.college + "</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#Details\" onclick='loadDetails(" + stu.id + ")'>\n" +
                "More\n" +
                "</button>\n" +
                "<button class='btn btn-danger btn-xs' onclick='delStudent(" + stu.id + ");'>" +
                "Del" +
                "</button>" +
                "</td>\n" +
                "</tr>");
        });
    });
};

var delAdvertise = function (adId) {
    $.post("/delAds", {adId: adId}, function (res) {
        if (res.code != 200) {
            alert(res.msg);
        } else {
            flashadvertise();
        }
    });
};

function addAdvertise() {
    var url = $("#urlinput").val();
    $.post("/addAds", {url: url}, function (res) {
        if (res.code == 200) {
            flashadvertise();
        } else {
            alert(res.code);
        }
    });
}

function edituser(t) {
    var chids = $(t).closest('td').closest('tr').find("td");
    var userid = chids.eq(0).text();
    var username = chids.eq(1).text();
    var ct = chids.eq(2).text();
    var ut = chids.eq(3).text();
    $("#eupassword").val("");
    $("#euid").val(userid);
    $("#eRole").val(username);
    $("#eucreateTime").val(ct);
    $("#euupdateTime").val(ut);
}

function deluser(t) {
    var row = $(t).closest('td').closest('tr');
    var chids = row.find("td");
    var userid = chids.eq(0).text();
    $.post("/delUser", {loginId: userid}, function (res) {
        alert(res.msg);
        if (res.code == 200) {
            row.remove();
        }
    });
}

function adduser() {
    var loginId = $("#loginId").val();
    var role = $("#selRole").val();
    var password = $("#upassword").val();
    $.post("/addUser", {loginId: loginId, role: role, password: password}, function (res) {
        if (res.code == 200) {
            flashUser();
        } else {
            alert(res.msg);
        }
    });
    var loginId = $("#loginId").val("");
    var role = $("#selRole").val("user");
    var password = $("#upassword").val("");
}

function searchHistory() {
    var sd = $("#hstartd").val();
    var ed = $("#hendd").val();
    var userId = $("#hsuserid").val();
    $.post("/searchAds", {startDate: sd, endDate: ed, userId: userId}, function (res) {
        var list = res.data;
        $("#searchNum").text(list.length);
        $("#hisbody").html("");
        $.each(list, function (idx, ad) {
            $("#hisbody").append("<tr>\n" +
                "<td>" + ad.userId + "</td>\n" +
                "<td><a href='" + ad.url + "'>" + ad.url + "</a></td>\n" +
                "<td>" + timeFormatter(ad.createTime) + "</td>\n" +
                "<td>\n" +
                "<button class=\"btn btn-danger btn-xs\" onclick='delAdvertise(" + ad.id + ");searchHistory();'>\n" +
                "<span class=\"glyphicon glyphicon-remove\"></span>\n" +
                "</button>\n" +
                "</td>\n" +
                "</tr>");
        });
    });
    $("#taskUserId").val(userId);
    $("#taskStartDate").val(sd);
    $("#taskEndDate").val(ed);
};

var flashStuSource = function () {
    $.post("/getStuSource", function (res) {
        var list = res.data;
        $("#SSselect").html("");
        var nulloption = "<option value=''></option>";
        $("#SSSearchSelect").html(nulloption);
        $("#userSSselect").html(nulloption);

        $("#SSselect").html(nulloption);

        $.each(list, function (idx, ss) {
            var inv = "<option value='" + ss.name + "'>" + ss.name + "</option>";
            $("#SSselect").append(inv);
            $("#SSSearchSelect").append(inv);
            $("#userSSselect").append(inv);
        });
    });
};

var FBHelper = function (answer) {
    if (answer == null) return;
    var an = answer.split(',');
    if (typeof(an) == "undefined" || typeof(an) == null) return answer;
    return an;
};

var updateFU = function (id, stuId) {
    var edspan = $("#edspan" + id);
    if (edspan.hasClass("glyphicon-edit")) {
        edspan.removeClass("glyphicon-edit");
        edspan.addClass("glyphicon-ok");
        $("#flid" + id).attr("disabled", false);
        $("#ta" + id).attr("disabled", false);
    } else if (edspan.hasClass("glyphicon-ok")) {
        var note = $("#ta" + id).val();
        var classification = $("#flid" + id).val();
        $.post("/updateFollowUp", {id: id, stuId: stuId, note: note, classification: classification}, function (res) {
            if (res.code != 200) {
                alert(res.code);
            }
        });
        edspan.removeClass("glyphicon-ok");
        edspan.addClass("glyphicon-edit");
        $("#flid" + id).attr("disabled", true);
        $("#ta" + id).attr("disabled", true);
    } else {
        alert("some error!");
    }
};

var addFU = function (stuId) {
    var note = $("#dtfp1").val();
    var classification = $("#newcla").val();
    $.post("/addFollowUp", {stuId: stuId, note: note, classification: classification}, function (res) {
        if (res.code == 200) {
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

var flashFollowUp = function (stuId) {
    $.post("/searchFollowUp", {stuId: stuId}, function (res) {
        var fus = res.data;
        $("#followuplist").html("");
        $.each(fus, function (idx, fu) {
            var cla = fu.classification;
            var claA = cla == 'A' ? "selected='selected'" : "";
            var claB = cla == 'B' ? "selected='selected'" : "";
            var claC = cla == 'C' ? "selected='selected'" : "";
            $("#followuplist").append("" +
                "<div class='form-group' id='fufg" + fu.id + "'>" +
                "<label class='col-sm-2 control-label'>Follow Up:</label> " +
                "<div class='col-sm-4' style='text-align: left;line-height:27px;padding-left:4%;'>" + timeFormatter(fu.createTime) +
                "</div>" +
                "<div class='col-sm-4' style='text-align: left;'> " +
                "<select id='flid" + fu.id + "' class='form-control' style='width: 85%;' disabled='disabled'>" +
                "<option value='A' " + claA + ">A: Interested</option>" +
                "<option value='B' " + claB + ">B: Hesitate</option>" +
                "<option value='C' " + claC + ">C: Rejected</option>" +
                "</select> " +
                "</div>" +
                "<br/><br/>" +
                "<div class='col-sm-2' style='text-align: right;'>" +
                "<button class='btn btn-danger btn-xs' onclick='delFU(" + fu.id + ")'>" +
                "<span class='glyphicon glyphicon-remove' onclick=''></span>" +
                "</button>&nbsp;&nbsp;" +
                "<button class='btn btn-info btn-xs' onclick='updateFU(" + fu.id + "," + stuId + ")' >" +
                "<span id='edspan" + fu.id + "' class='glyphicon glyphicon-edit'></span>" +
                "</button>" +
                "</div>" +
                "<div class='col-sm-10'>" +
                "<textarea id='ta" + fu.id + "' class='form-control' style='width: 96%;resize: none;' rows='4' disabled='true'>" + fu.note + "</textarea>" +
                "</div>" +
                "</div>");
        });
    });
};

var getFeedback = function (feedback, num) {
    switch (num) {
        case 1:
            return FBHelper(feedback.answer1);
        case 2:
            return FBHelper(feedback.answer2);
        case 3:
            return FBHelper(feedback.answer3);
        case 4:
            return FBHelper(feedback.answer4);
        case 5:
            return FBHelper(feedback.answer5);
        case 6:
            return FBHelper(feedback.answer6);
        case 7:
            return FBHelper(feedback.answer7);
        case 8:
            return FBHelper(feedback.answer8);
        case 9:
            return FBHelper(feedback.answer9);
        case 10:
            return FBHelper(feedback.answer10);
        case 11:
            return FBHelper(feedback.answer11);
        case 12:
            return FBHelper(feedback.answer12);
        case 13:
            return FBHelper(feedback.answer13);
        case 14:
            return FBHelper(feedback.answer14);
        case 15:
            return FBHelper(feedback.answer15);
        case 16:
            return FBHelper(feedback.answer16);
        case 17:
            return FBHelper(feedback.answer17);
        case 18:
            return FBHelper(feedback.answer18);
        case 19:
            return FBHelper(feedback.answer19);
        case 20:
            return FBHelper(feedback.answer20);
        case 21:
            return FBHelper(feedback.answer21);
    }
};

var flashSearchTable=function () {
  $("#searchtablebody").html("");
  $.post("/getTable",function (res) {
      var list=res.data;
      $.each(list,function (idx,son) {
          if(son.fbanswers.length!=1){
              var answers="";
              $.each(son.fbanswers,function (idx,gson) {
                  if(gson.location!=99)answers+="<label class='"+son.fbquestion.type+"-inline'><input type='"+son.fbquestion.type+"' name='forsearch"+son.fbquestion.location+"' value='"+gson.location+"'/>"+gson.details+"</label>";
              });
              $("#searchtablebody").append("" +
                  "<div class='form-group'>" +
                  "<label class='col-sm-12 control-label' style='text-align: center'>" +son.fbquestion.details+
                  "</label>" +
                  "<div class='col-sm-12'>" +answers+
                  "</div>" +
                  "</div>" +
                  "");
          }
      });
  });
};

var flashTable = function (stuId) {
    $("#fankuibody").html("");
    var feedback;
    $.ajax({
        type: "post",
        url: "/getFeedback",
        data: {stuId: stuId},
        async: false,
        success: function (res) {
            feedback = res.data;
        }
    });
    $.post("/getTable", function (res) {
        var list = res.data;
        $.each(list, function (idx, sth) {
            var answers = sth.fbanswers;
            var answersString = "";
            var ans = getFeedback(feedback, sth.fbquestion.location);
            if (answers.length == 1) {
                answersString = "<input name='fkquestion21' value='" + feedback.answer21 + "' type='text' id='other" + sth.fbquestion.location + "' style='width:80%;'/>";
            } else {
                $.each(answers, function (idxx, answer) {
                    var chk = "";
                    for (var i = 0; i < ans.length; i++) {
                        if (ans[i] == idxx + 1) {
                            chk = "checked='checked'";
                            break;
                        }
                    }
                    var txt = ans[ans.length - 1].length > 1 ? ans[ans.length - 1] : "";
                    var checkn="";
                    if (answer.location == 99)checkn=txt==""?"":"checked='checked'";
                    answersString += "<label class='" + sth.fbquestion.type + "-inline'><input " + chk+checkn + " type='" + sth.fbquestion.type + "' name='fkquestion" + sth.fbquestion.location + "' id='fkanswerid" + answer.location + "' value='" + answer.location + "'/>" + answer.details + "</label>";
                    if (answer.location == 99) {

                        answersString += "<input type='text' id='other" + sth.fbquestion.location + "' style='width:20%;' value='" + txt + "'/>";
                    }
                });
            }
            $("#fankuibody").append("" +
                "<div class='form-group'>" +
                "<label class='col-sm-12 control-label' style='text-align: center'>" + sth.fbquestion.details +
                "</label> " +
                "<div class='col-sm-12'>" + answersString +
                "</div>" +
                "</div>" +
                "");
        });
    });
}

var loadDetails = function (stuId) {
    $.post("/getStudent", {stuId: stuId}, function (res) {
        var stu = res.data;
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
    flashFollowUp(stuId);
    flashTable(stuId);
};

var updateAns = function (name) {
    var answer = "";
    $("input[name='" + name + "']:checked").each(function () {
        answer = answer + $(this).val() + ",";
        if ($(this).val() == "99") {
            var kn = $(this).parent().next().val();
            answer = answer + kn;
        }
    });
    return answer.substring(0, answer.length - 1);
};

var updateQuestion=function (id,location) {
    if($("#updateQuestionSpan"+location).hasClass("glyphicon-edit")){
        $("#updateQuestionSpan"+location).removeClass("glyphicon-edit");
        $("#updateQuestionSpan"+location).addClass("glyphicon-ok");
        $("#questionDetails"+location).attr("disabled",false);
        $("#questionType"+location).attr("disabled",false);
        $("#questionLocation"+location).attr("disabled",false);
    }else{
        var loc=$("#questionLocation"+location).val();
        var type=$("#questionType"+location).val();
        var details=$("#questionDetails"+location).val();
        $.post("/updateQuestion",{id:id,location:loc,type:type,details:details},function (res) {
            if(res.code==200){
                if(loc!=location){
                    flashEditTable();
                    flashSearchTable();
                }
                else{
                    $("#updateQuestionSpan"+location).removeClass("glyphicon-ok");
                    $("#updateQuestionSpan"+location).addClass("glyphicon-edit");
                    $("#questionDetails"+location).attr("disabled","disabled");
                    $("#questionType"+location).attr("disabled","disabled");
                    $("#questionLocation"+location).attr("disabled","disabled");
                }
            }else{
                alert(res.msg);
            }
        });
    }
};

var deleteQuestion=function (id) {
    $.post("/delQuestion",{id:id},function (res) {
        if(res.code==200){
            flashEditTable();
            flashSearchTable();
        }
    });
};

var addAnswer=function (questionId,location) {
    var details=$("#newanswer"+location).val();
    $.post("/addAnswer",{questionId:questionId,details:details},function (res) {
        if(res.code==200){
            flashEditTable();
            flashSearchTable();
        }
    });
};

var updateAnswer=function (id,questionId,questionLocation,answerLocation) {
    if($("#spanquestion"+questionLocation+"answer"+answerLocation).hasClass("glyphicon-edit")){
        $("#spanquestion"+questionLocation+"answer"+answerLocation).removeClass("glyphicon-edit");
        $("#spanquestion"+questionLocation+"answer"+answerLocation).addClass("glyphicon-ok");
        $("#txtquestion"+questionLocation+"answer"+answerLocation).attr("disabled",false);
    }else{
        var details=$("#txtquestion"+questionLocation+"answer"+answerLocation).val();
        $.post("/updateAnswer",{id:id,questionId:questionId,location:answerLocation,details:details},function (res) {
            if(res.code==200){
                $("#spanquestion"+questionLocation+"answer"+answerLocation).removeClass("glyphicon-ok");
                $("#spanquestion"+questionLocation+"answer"+answerLocation).addClass("glyphicon-edit");
                $("#txtquestion"+questionLocation+"answer"+answerLocation).attr("disabled","disabled");
            }else{
                alert(res.msg);
            }
        });
    }
};

var deleteAnswer=function (id) {
    $.post("/delAnswer",{id:id},function (res) {
        if(res.code==200){
            flashEditTable();
            flashSearchTable();
        }
    });
};

var toaddAnswer=function (questionId,location) {
    $("#toadd"+location).html("<div class='input-group'>" +
        "<input id='newanswer"+location+"' type='text' class='form-control'/>" +
        "<div class='input-group-btn'>" +
        "<button type='button' class='btn btn-success' onclick='addAnswer("+questionId+","+location+")'><span class='glyphicon glyphicon-ok'></span></button> " +
        "</div> " +
        "</div>");
};

var upQuestionModal=function () {
    $("#addQuestionModal").modal();
};



var flashEditTable=function () {
    $("#Table").html("<hr/>");
    $.post("/getTable",function (res) {
        var list=res.data;
        var locopt=list[list.length-1].fbquestion.location;
        $.each(list,function (idx,son) {
            var locoptstring="";
            for(var i=1;i<=locopt;i++){
                var chkn=i==idx+1?"selected='selected'":"";
                locoptstring+="<option "+chkn+" value='"+i+"'>"+i+"</option>";
            }
            var chxtypeopt=son.fbquestion.type=="checkbox"?"selected='selected":"";
            var rdotypeopt=son.fbquestion.type=="radio"?"selected='selected":"";
            var txttypeopt=son.fbquestion.type=="text"?"selected='selected":"";
            var answers="";
            $.each(son.fbanswers,function (idx,gson) {
                if(gson.location!=99){
                    answers=answers+"<div class='col-xs-2' style='margin-top: 5px;'>" +
                        "<div class='input-group'>" +
                        "<input id='txtquestion"+son.fbquestion.location+"answer"+gson.location+"' type='text' class='form-control' value='"+gson.details+"' disabled='disabled'/> " +
                        "<div class='input-group-btn'>" +
                        "<button type='button' class='btn btn-info' onclick='updateAnswer("+gson.id+","+son.fbquestion.id+","+son.fbquestion.location+","+gson.location+")'><span id='spanquestion"+son.fbquestion.location+"answer"+gson.location+"' class='glyphicon glyphicon-edit'></span></button>" +
                        "<button type='button' class='btn btn-danger' onclick='deleteAnswer("+gson.id+")'><span class='glyphicon glyphicon-remove'></span></button>" +
                        "</div>" +
                        "</div>" +
                        "</div>";
                }
            });
            if(son.fbquestion.type!="text"){
                answers+="" +
                    "<div class='col-xs-2' style='margin-top: 5px;' id='toadd"+son.fbquestion.location+"'>" +
                    "<div class='input-group'>" +
                    "<div class='input-group-btn'>" +
                    "<button class='btn btn-info' style='float: left;' onclick='toaddAnswer("+son.fbquestion.id+","+son.fbquestion.location+")'>" +
                    "<span class='glyphicon glyphicon-plus'></span>" +
                    "</button></div></div></div>";
            }
            $("#Table").append("<div class='row'>" +
                "<div class='col-sm-6'>" +
                "<div class='input-group'>" +
                "<div class='input-group-btn'>" +
                "<select id='questionLocation"+son.fbquestion.location+"' class='btn btn-default' disabled='disabled'>" +locoptstring+
                "</select>" +
                "<select id='questionType"+son.fbquestion.location+"' class='btn btn-default' disabled='disabled'>" +
                "<option "+rdotypeopt+" value='radio'>radio</option>" +
                "<option "+chxtypeopt+"value='checkbox'>checkbox</option>" +
                "<option "+txttypeopt+"value='text'>text</option>" +
                "</select> " +
                "</div>" +
                "<input disabled='disabled' id='questionDetails"+son.fbquestion.location+"' type='text' class='form-control' value='"+son.fbquestion.details+"'/>" +
                "<div class='input-group-btn'>" +
                "<button type='button' class='btn btn-success' onclick='updateQuestion("+son.fbquestion.id+","+son.fbquestion.location+")'><span id='updateQuestionSpan"+son.fbquestion.location+"' class='glyphicon glyphicon-edit'></span></button>" +
                "<button type='button' class='btn btn-danger' onclick='deleteQuestion("+son.fbquestion.id+")'><span class='glyphicon glyphicon-remove'></span></button>" +
                "</div> " +
                "</div>" +
                "</div>" +
                "</div>" +
                "<div class='row'>" +answers+
                "</div> " +
                "<hr/>");
        });
        $("#Table").append("<div class='row'>" +
            "<div class='col-sm-12'>" +
            "<div class='input-group'>" +
            "<div class='input-group-btn'>" +
            "<button class='btn btn-success' onclick='upQuestionModal()'><span class='glyphicon glyphicon-plus'></span></button>" +
            "</div> " +
            "</div> " +
            "</div> " +
            "</div>");
    });
};
//Jquery
$("#addQueBtn").click(function () {
    var type=$("#addQueType").val();
    var details=$("#addQueDetails").val();
    $.post("/addQuestion",{type:type,details:details},function (res) {
        if(res.code==200){
            flashEditTable();
            flashSearchTable();
        }else{
            alert(res.msg);
        }
    });
});
$("#submitdt").click(function () {
    //followup
    var stuId = $("#edstuId").val();
    if ($.trim($("#dtfp1").val()).length > 0) {
        addFU(stuId);
    }
    //student
    var name = $("#dtname").val();
    var gender = $("#dtgender").val();
    var age = $("#dtage").val();
    var phone = $("#dtphonenum").val();
    var email = $("#dtemail").val();
    var college = $("#dtcollegename").val();
    var qqWechat = $("#dtqqwechat").val();
    var major = $("#dtmajor").val();
    var walkinDate = $("#dtwalkindate").val();
    var marks = $("#dtmarks").val();
    var insit = $("#dtinsit").val();
    var intention = $("#dtintention").val();
    var stusource = $("#stusource").val();
    if ($.trim(stusource).length > 0) {
        $.post("/addStuSource", {name: stusource}, function (res) {
            if (res.code == 200) {
                flashStuSource();
                $("#stusource").val("");
            } else {
                alert(res.msg);
            }
        });
    } else {
        stusource = $("#SSselect").val();
    }
    $.post("/updateStudent",
        {
            id: stuId,
            name: name,
            gender: gender,
            age: age,
            phone: phone,
            email: email,
            college: college,
            major: major,
            walkingDate: walkinDate,
            interviewNote: insit,
            marks: marks,
            intention: intention,
            studentSource: stusource,
            qqWechat: qqWechat
        },
        function (res) {
            if (res.code != 200) {
                alert("updateStudent" + res.msg);
            }
        });
    //feedback
    var answer1 = updateAns("fkquestion1");
    var answer2 = updateAns("fkquestion2");
    var answer3 = updateAns("fkquestion3");
    var answer4 = updateAns("fkquestion4");
    var answer5 = updateAns("fkquestion5");
    var answer6 = updateAns("fkquestion6");
    var answer7 = updateAns("fkquestion7");
    var answer8 = updateAns("fkquestion8");
    var answer9 = updateAns("fkquestion9");
    var answer10 = updateAns("fkquestion10");
    var answer11 = updateAns("fkquestion11");
    var answer12 = updateAns("fkquestion12");
    var answer13 = updateAns("fkquestion13");
    var answer14 = updateAns("fkquestion14");
    var answer15 = updateAns("fkquestion15");
    var answer16 = updateAns("fkquestion16");
    var answer17 = updateAns("fkquestion17");
    var answer18 = updateAns("fkquestion18");
    var answer19 = updateAns("fkquestion19");
    var answer20 = updateAns("fkquestion20");
    var answer21 = $("input[name='fkquestion21']").val();
    $.post("/updateFeedback",
        {
            stuId: stuId, answer1: answer1, answer2: answer2, answer3: answer3, answer4: answer4, answer5: answer5,
            answer6: answer6, answer7: answer7, answer8: answer8, answer9: answer9, answer10: answer10,
            answer11: answer11, answer12: answer12, answer13: answer13, answer14: answer14, answer15: answer15,
            answer16: answer16, answer17: answer17, answer18: answer18, answer19: answer19, answer20: answer20,answer21: answer21
        },
        function (res) {
            if (res.code != 200) {
                alert("updateFeedback" + res.msg);
            }
        });
    flashstudents();
});
$("#submiteu").click(function () {
    var a = $("#euid").val();
    var b = $("#eRole").val();
    var c = $("#eupassword").val();
    $.post("/updateUser", {loginId: a, role: b, password: c}, function () {
        if (res.code != 200) {
            alert(res.msg);
        }
    });
    flashUser();
});

$("#urlinput").keydown(function (e) {
    if (e.keyCode == 13) {
        addAdvertise();
        $("#urlinput").val("");
    }
});

$("#stable1").click(function () {
   var dis=$("#fankuiTable").css("display");
   if(dis=="none"){
       $("#fankuiTable").css("display","");
   }else{
       $("#fankuiTable").css("display","none");
   }
});

$("#searchShowTable").click(function () {
    var dis=$("#tableinsearch").css("display");
    if(dis=="none"){
        $("#tableinsearch").css("display","");
    }else{
        $("#tableinsearch").css("display","none");
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
        success: function (res) {
            if (res.code == 200) {
                flashstudents();
            } else {
                alert(res.msg);
            }
        }
    });
    $("#nsname").val("");
    $("#nsgender").val("");
    $("#nsage").val("");
    $("#nsphonenum").val("");
    $("#nsemail").val("");
    $("#nscollegename").val("");
    $("#nsmajor").val("");
});

$("#sssearch").click(function () {
    var sd = $("#sssdate").val();
    var ed = $("#ssedate").val();
    var ssuserID=$("#ssuserId").val();
    var name = $("#ssname").val();
    var clf = $("#selectclass option:selected").val();
    var source = $("#SSSearchSelect option:selected").val();
    var answer1="";
    var answer2="";
    var answer3="";
    var answer4="";
    var answer5="";
    var answer6="";
    var answer7="";
    var answer8="";
    var answer9="";
    var answer10="";
    var answer11="";
    var answer12="";
    var answer13="";
    var answer14="";
    var answer15="";
    var answer16="";
    var answer17="";
    var answer18="";
    var answer19="";
    var answer20="";
    if($("#tableinsearch").css("display")!="none"){
        answer1=updateAns("forsearch1");
        answer2=updateAns("forsearch2");
        answer3=updateAns("forsearch3");
        answer4=updateAns("forsearch4");
        answer5=updateAns("forsearch5");
        answer6=updateAns("forsearch6");
        answer7=updateAns("forsearch7");
        answer8=updateAns("forsearch8");
        answer9=updateAns("forsearch9");
        answer10=updateAns("forsearch10");
        answer11=updateAns("forsearch11");
        answer12=updateAns("forsearch12");
        answer13=updateAns("forsearch13");
        answer14=updateAns("forsearch14");
        answer15=updateAns("forsearch15");
        answer16=updateAns("forsearch16");
        answer17=updateAns("forsearch17");
        answer18=updateAns("forsearch18");
        answer19=updateAns("forsearch19");
        answer20=updateAns("forsearch20");
        $("#stuExcelAnswer1").val(answer1);
        $("#stuExcelAnswer2").val(answer2);
        $("#stuExcelAnswer3").val(answer3);
        $("#stuExcelAnswer4").val(answer4);
        $("#stuExcelAnswer5").val(answer5);
        $("#stuExcelAnswer6").val(answer6);
        $("#stuExcelAnswer7").val(answer7);
        $("#stuExcelAnswer8").val(answer8);
        $("#stuExcelAnswer9").val(answer9);
        $("#stuExcelAnswer10").val(answer10);
        $("#stuExcelAnswer11").val(answer11);
        $("#stuExcelAnswer12").val(answer12);
        $("#stuExcelAnswer13").val(answer13);
        $("#stuExcelAnswer14").val(answer14);
        $("#stuExcelAnswer15").val(answer15);
        $("#stuExcelAnswer16").val(answer16);
        $("#stuExcelAnswer17").val(answer17);
        $("#stuExcelAnswer18").val(answer18);
        $("#stuExcelAnswer19").val(answer19);
        $("#stuExcelAnswer20").val(answer20);
    }
    $.post("/searchStudent", {
        name: name,
        startDate: sd,
        endDate: ed,
        userId:ssuserID,
        classification: clf,
        source: source,
        answer1:answer1,
        answer2:answer2,
        answer3:answer3,
        answer4:answer4,
        answer5:answer5,
        answer6:answer6,
        answer7:answer7,
        answer8:answer8,
        answer9:answer9,
        answer10:answer10,
        answer11:answer11,
        answer12:answer12,
        answer13:answer13,
        answer14:answer14,
        answer15:answer15,
        answer16:answer16,
        answer17:answer17,
        answer18:answer18,
        answer19:answer19,
        answer20:answer20
    }, function (res) {
        if (res.code == 200) {
            var list = res.data;
            $("#ssbody").html("");
            $.each(list, function (idx, stu) {
                var writerId = stu.writerId;
                var name = stu.name;
                var gender = stu.gender;
                var age = stu.age;
                var phone = stu.phone;
                var email = stu.email;
                var college = stu.college;
                var createTime = stu.createTime;
                $("#ssbody").append("<tr>\n" +
                    "<td>" + writerId + "</td>\n" +
                    "<td>" + timeFormatter(createTime) + "</td>\n" +
                    "<td>" + name + "</td>\n" +
                    "<td>" + gender + "</td>\n" +
                    "<td>" + age + "</td>\n" +
                    "<td>" + phone + "</td>\n" +
                    "<td>" + email + "</td>\n" +
                    "<td>" + college + "</td>\n" +
                    "<td>\n" +
                    "<button class=\"btn btn-primary btn-xs\" data-toggle=\"modal\" data-target=\"#Details\" onclick='loadDetails(" + stu.id + ")'>\n" +
                    "More\n" +
                    "</button>\n" +
                    "<button class='btn btn-danger btn-xs' onclick='delStudent(" + stu.id + ");$(\"#sssearch\").click();'>" +
                    "Del" +
                    "</button>" +
                    "</td>\n" +
                    "</tr>");
            });
        }
    });
    $("#stuExcelUserId").val(ssuserID);
    $("#stuExcelName").val(name);
    $("#stuExcelStartDate").val(sd);
    $("#stuExcelEndDate").val(ed);
    $("#stuExcelClassification").val(clf);
    $("#stuExcelSource").val(source);
});

$("#research").click(function () {
    var userId = $("#userSearchUserId").val();
    var startDate = $("#userSearchStartDate").val();
    var endDate = $("#userSearchEndDate").val();
    var classification = $("#rcselect option:selected").val();
    //userSSselect
    var source = $("#userSSselect option:selected").val();
    $.post("/searchCount", {
        userId: userId,
        startDate: startDate,
        endDate: endDate,
        classification: classification,
        source: source
    }, function (res) {
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
flashEditTable();
flashStuSource();
flashstudents();
flashadvertise();
flashSearchTable();