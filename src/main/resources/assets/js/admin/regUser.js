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