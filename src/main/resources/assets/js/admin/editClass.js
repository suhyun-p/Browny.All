$(document).ready(function () {
    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/admin/getInstructorList',
        type: 'GET',
        success: function (response) {
            $(response).each(function (index, instructor) {
                $("#instructor1").append('<option value=' + instructor.userNo + '>' + instructor.nickname + '</option>');
                $("#instructor2").append('<option value=' + instructor.userNo + '>' + instructor.nickname + '</option>');
            });

            loadClassInfo($.urlParam('classNo'));
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });

    $("#instructor1").change(function(e) {
        var instructorNo = $(e.target).val();
        setInstructorInfo1(instructorNo);
    });

    $("#instructor2").change(function(e) {
        var instructorNo = $(e.target).val();
        setInstructorInfo2(instructorNo);
    });
});

function addDateOption(dateOption) {
    dateOption = dateOption == undefined ? "" : dateOption;
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"dateOption\" placeholder=\"" + dateOption +"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divDateOption").append(html)
}

function addPriceOption(priceOption) {
    priceOption = priceOption == undefined ? "" : priceOption;
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"priceOption\" placeholder=\"" + priceOption +"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divPriceOption").append(html)
}

function loadClassInfo(classNo) {
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/admin/getClassDetail?classNo=' + classNo,
        type: 'GET',
        success: function (response) {
            rendering(response);
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });
}

function rendering(classDetail) {
    $("#genre").val(classDetail.genre);
    $("#region").val(classDetail.region);
    $("#classType").val(classDetail.type);
    $("#only").val(classDetail.only);
    $("#title").val(classDetail.title);
    $("#instructor1").val(classDetail.instructorNo1);
    setInstructorInfo1(classDetail.instructorNo1);
    if(classDetail.instructorNo2 != null)  {
        $("#instructor2").val(classDetail.instructorNo2);
        setInstructorInfo2(classDetail.instructorNo2);
    }
    $("#startDate").val(classDetail.startDate);
    $("#endDate").val(classDetail.endDate);
    $("#dateSummary").val(classDetail.dateSummary);
    for(var i=0; i<classDetail.dateOptionList.length; i++) {
        if(i==0) $("#dateOption").val(classDetail.dateOptionList[i]);
        else addDateOption(classDetail.dateOptionList[i]);
    }
    $("#startTime").val(classDetail.startTime);
    $("#endTime").val(classDetail.endTime);
    $("#location").val(classDetail.location);
    $("#malePrice").val(classDetail.malePrice);
    $("#femalePrice").val(classDetail.femalePrice);
    for(var i=0; i<classDetail.priceOptionList.length; i++) {
        if(i==0) $("#priceOption").val(classDetail.priceOptionList[i]);
        else addPriceOption(classDetail.priceOptionList[i]);
    }
    $("#classAccountText").val(classDetail.payment);
    $("#classImage").val(classDetail.classImage);
}

function setInstructorInfo1(instructorNo) {
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/admin/getUserInfo?userNo=' + instructorNo,
        type: 'GET',
        success: function (response) {
            if(response.account != null && response.account != "") {
                $("#divInstructorAccount1").show();
                $("#instructorAccountText1").text(response.account);
            }
            else  $("#divInstructorAccount1").hide();

            if(response.contact != null && (response.contact.phoneNo != null && response.contact.phoneNo != "")) {
                $("#divInstructorPhoneNo1").show();
                $("#instructorPhoneNoText1").text('(' + response.nickname + ' : PhoneNo) ' + response.contact.phoneNo);
            }
            else  $("#divInstructorPhoneNo1").hide();

            if(response.contact != null && (response.contact.kakaoTalk != null && response.contact.kakaoTalk != "")) {
                $("#divInstructorKakaoTalk1").show();
                $("#instructorKakaoTalkText1").text('(' + response.nickname + ' : KakaoTalk) ' + response.contact.kakaoTalk);
            }
            else  $("#divInstructorKakaoTalk1").hide();
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });
}

function setInstructorInfo2(instructorNo) {
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/admin/getUserInfo?userNo=' + instructorNo,
        type: 'GET',
        success: function (response) {
            if(response.account != null && response.account != "") {
                $("#divInstructorAccount2").show();
                $("#instructorAccountText2").text(response.account);
            }
            else  $("#divInstructorAccount2").hide();

            if(response.contact != null && (response.contact.phoneNo != null && response.contact.phoneNo != "")) {
                $("#divInstructorPhoneNo2").show();
                $("#instructorPhoneNoText2").text('(' + response.nickname + ' : PhoneNo) ' + response.contact.phoneNo);
            }
            else  $("#divInstructorPhoneNo2").hide();

            if(response.contact != null && (response.contact.kakaoTalk != null && response.contact.kakaoTalk != "")) {
                $("#divInstructorKakaoTalk2").show();
                $("#instructorKakaoTalkText2").text('(' + response.nickname + ' : KakaoTalk) ' + response.contact.kakaoTalk);
            }
            else  $("#divInstructorKakaoTalk2").hide();
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });
}