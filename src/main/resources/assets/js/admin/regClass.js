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
                alert(response);
            },
            error: function (request, status, error) {
                alert("실패");
            }
        });

    });

    $("#instructor2").change(function() {

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