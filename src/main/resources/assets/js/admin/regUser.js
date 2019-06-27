$(document).ready(function () {
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

function addCareer() {
    var html = "<div class=\"col-md-12 mb-3\">";
    html += "<div class=\"custom-control-inline\" style=\"width: 100%\">";
    html += "<input type=\"text\" class=\"form-control\" name=\"career\" placeholder=\"\">&nbsp;";
    html += "<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"javascript:$(this).parent().parent().remove();\">Del</button>";
    html += "</div>";
    html += "</div>";
    $("#divCareer").append(html)
}