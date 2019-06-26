$(document).ready(function () {
    $("#instructor").click(function() {
        if($("#instructor").prop("checked")) {
            $("#instructorInfo").show();
        }
        else {
            $("#instructorInfo").hide();
        }
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