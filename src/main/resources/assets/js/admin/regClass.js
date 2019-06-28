$(document).ready(function () {
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
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });

    $("#instructor1").change(function(e) {
        var instructorNo = $(e.target).val();
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

    });

    $("#instructor2").change(function(e) {
        var instructorNo = $(e.target).val();
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
    });
});

function addDateOption() {
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"dateOption\" placeholder=\"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divDateOption").append(html)
}

function addPriceOption() {
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"priceOption\" placeholder=\"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divPriceOption").append(html)
}