$(document).ready(function () {

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/api/class/getClassSimpleList',
        type: 'GET',
        success: function (response) {
            $("#classSimpleTemplate").tmpl(response).appendTo("#classSimpleList");
        },
        error: function (request, status, error) {
            alert("실패");
        }
    })
});