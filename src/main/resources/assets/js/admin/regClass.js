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
                    $("#instructorPhoneNo1").data("contact", response.contact.phoneNo);
                    $("#instructorPhoneNo1").data("instructor-no", response.userNo);
                }
                else  $("#divInstructorPhoneNo1").hide();

                if(response.contact != null && (response.contact.kakaoTalk != null && response.contact.kakaoTalk != "")) {
                    $("#divInstructorKakaoTalk1").show();
                    $("#instructorKakaoTalkText1").text('(' + response.nickname + ' : KakaoTalk) ' + response.contact.kakaoTalk);
                    $("#instructorKakaoTalk1").data("contact", response.contact.kakaoTalk);
                    $("#instructorKakaoTalk1").data("instructor-no", response.userNo);
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
                    $("#instructorPhoneNo2").data("contact", response.contact.phoneNo);
                    $("#instructorPhoneNo2").data("instructor-no", response.userNo);
                }
                else  $("#divInstructorPhoneNo2").hide();

                if(response.contact != null && (response.contact.kakaoTalk != null && response.contact.kakaoTalk != "")) {
                    $("#divInstructorKakaoTalk2").show();
                    $("#instructorKakaoTalkText2").text('(' + response.nickname + ' : KakaoTalk) ' + response.contact.kakaoTalk);
                    $("#instructorKakaoTalk2").data("contact", response.contact.kakaoTalk);
                    $("#instructorKakaoTalk2").data("instructor-no", response.userNo);
                }
                else  $("#divInstructorKakaoTalk2").hide();
            },
            error: function (request, status, error) {
                alert("실패");
            }
        });
    });

    $("#regClass").click(function() {
        var data = {};
        data["genre"] = $("#genre").val();
        data["region"] = $("#region").val();
        data["type"] = $("#classType").val();
        data["only"] = $("#only").val() == "" ? null : $("#only").val();

        data["title"] = $("#title").val();
        data["instructorNo1"] = $("#instructor1").val();
        data["instructorNo2"] = $("#instructor2").val();
        data["startDate"] = $("#startDate").val();
        data["endDate"] = $("#endDate").val();
        data["dateSummary"] = $("#dateSummary").val();

        var dateOptionList = [];
        $.each($('input[name="dateOption"]'), function(index, option){
            if(option.value != undefined && option.value != "") dateOptionList.push(option.value);
        });
        data["dateOptionList"] = dateOptionList;

        data["startTime"] = $("#startTime").val();
        data["endTime"] = $("#endTime").val();
        data["location"] = $("#location").val();
        data["malePrice"] = $("#malePrice").val();
        data["femalePrice"] = $("#femalePrice").val();

        var priceOptionList = [];
        $.each($('input[name="priceOption"]'), function(index, option){
            if(option.value != undefined && option.value != "") priceOptionList.push(option.value);
        });
        data["priceOptionList"] = priceOptionList;

        if($("#instructorAccount1").is(":checked")) data["payment"] = $("#instructorAccountText1").text();
        else if($("#instructorAccount2").is(":checked")) data["payment"] = $("#instructorAccountText1").text();
        else if($("#classAccount").is(":checked")) data["payment"] =$("#classAccountText").val();

        var contactList = []
        if($("#instructorPhoneNo1").is(":checked")) contactList.push({"contact" : $("#instructorPhoneNo1").data("contact"), "instructorNo" : $("#instructorPhoneNo1").data("instructor-no"), "type" : $("#instructorPhoneNo1").data("contact-type")});
        if($("#instructorKakaoTalk1").is(":checked")) contactList.push({"contact" : $("#instructorKakaoTalk1").data("contact"), "instructorNo" : $("#instructorKakaoTalk1").data("instructor-no"), "type" : $("#instructorKakaoTalk1").data("contact-type")});
        if($("#instructorPhoneNo2").is(":checked")) contactList.push({"contact" : $("#instructorPhoneNo2").data("contact"), "instructorNo" : $("#instructorPhoneNo2").data("instructor-no"), "type" : $("#instructorPhoneNo2").data("contact-type")});
        if($("#instructorKakaoTalk2").is(":checked")) contactList.push({"contact" : $("#instructorKakaoTalk2").data("contact"), "instructorNo" : $("#instructorKakaoTalk2").data("instructor-no"), "type" : $("#instructorKakaoTalk2").data("contact-type")});
        if($("#classContact").is(":checked")) contactList.push({"contact" : $("#contact").val(), "instructorNo" : null, "type" : null});
        data["contactList"] = contactList;

        data["classImage"] = $("#classImage").val();
        console.log(data);

        $.ajax({
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/admin/regClass',
            type: 'POST',
            success: function (response) {
                alert("성공");
                // location.reload(); // 새로고침
            },
            error: function (request, status, error) {
                alert("실패");
            }
        })
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