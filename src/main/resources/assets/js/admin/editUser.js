$(document).ready(function () {

    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }

    loadUserInfo($.urlParam('userNo'));

    $("#instructor").click(function() {
        if($("#instructor").prop("checked")) {
            $("#instructorInfo").show();
        }
        else {
            $("#instructorInfo").hide();
        }
    });

    $("#signUp").click(function () {
        var data = {};
        data["nickname"] = $("#nickname").val();
        data["sex"] = $(':input[name=sex]:radio:checked').val();
        data["instructor"] = $("#instructor").is(":checked");

        if($("#instructor").is(":checked")) {
            data["account"] = $("#account").val();

            var contactList = new Array();
            if($("#phoneNo").val() != "") {
                var phoneNo = {"type":"P", "contact":$("#phoneNo").val()}
                contactList.push(phoneNo);
            }

            if($("#kakaoTalk").val() != "") {
                var kakaoTalk = {"type":"K", "contact":$("#kakaoTalk").val()}
                contactList.push(kakaoTalk);
            }

            if($("#facebook").val() != "") {
                var facebook = {"type":"F", "contact":$("#facebook").val()}
                contactList.push(facebook);
            }

            if($("#instagram").val() != "") {
                var instagram = {"type":"I", "contact":$("#instagram").val()}
                contactList.push(instagram);
            }

            if($("#youtubeUrl").val() != "") {
                var youtube = {"type":"Y", "name":$("#youtubeName").val(), "contact":$("#youtubeUrl").val()}
                contactList.push(youtube);
            }

            if($("#daumCafeUrl").val() != "") {
                var daumCafe = {"type":"DC", "name":$("#daumCafeName").val(), "contact":$("#daumCafeUrl").val()}
                contactList.push(daumCafe);
            }

            if($("#naverCafeUrl").val() != "") {
                var naverCafe = {"type":"NC", "name":$("#naverCafeName").val(), "contact":$("#naverCafeUrl").val()}
                contactList.push(naverCafe);
            }

            if($("#naverBandUrl").val() != "") {
                var naverBand = {"type":"NB", "name":$("#naverBandName").val(), "contact":$("#naverBandUrl").val()}
                contactList.push(naverBand);
            }
            data["contactList"] = contactList;

            var careerList= new Array();
            $("input[name='career']").each(function (index, career) {
                careerList.push(career.value);
            });
            data["careerList"] = careerList;
        }

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/admin/signUp',
            type: 'POST',
            success: function (response) {
                alert("성공");
                location.reload(); // 새로고침
            },
            error: function (request, status, error) {
                alert("실패");
            }
        })
    });
});

function loadUserInfo(userNo) {
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/admin/getUserInfo?userNo=' + userNo,
        type: 'GET',
        success: function (response) {
            rendering(response);
        },
        error: function (request, status, error) {
            alert("실패");
        }
    })
}

function rendering(userM) {

    // nickname
    $("#nickname").val(userM.nickname);

    // sex
    if (userM.sex == "M") $("#male").attr("checked", true);
    else if (userM.sex == "F") $("#female").attr("checked", true);

    // instructor
    if(userM.instructor) {
        $("#instructor").attr("checked", true);
        $("#instructorInfo").show();

        $("#account").val(userM.account);
        $("#phoneNo").val(userM.contact.phoneNo);
        $("#kakaoTalk").val(userM.contact.kakaoTalk);
        $("#facebook").val(userM.contact.facebook);
        $("#instagram").val(userM.contact.instagram);
        $("#youtubeName").val(userM.contact.youtube);
        $("#youtubeUrl").val(userM.contact.youtubeURL);
        $("#daumCafeName").val(userM.contact.daumCafe);
        $("#daumCafeUrl").val(userM.contact.daumCafeURL);
        $("#naverCafeName").val(userM.contact.naverCafe);
        $("#naverCafeUrl").val(userM.contact.naverCafeURL);
        $("#naverBandName").val(userM.contact.naverBand);
        $("#naverBandUrl").val(userM.contact.naverBandURL);

        for(var i=0; i<userM.careerList.length; i++) {
            if(i==0) $("#career").val(userM.careerList[i]);
            else addCareer(userM.careerList[i]);
        }
    }
}

function addCareer(career) {

    career = career == undefined ? "" : career;
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"career\" placeholder=\"\" value=\"" + career +"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divCareer").append(html)
}