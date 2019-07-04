$(document).ready(function () {

    var pathName = /\/(\w{1,})\/(\w{1,})/.exec(location.pathname);
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClassSimpleList?type=' + pathName[1] + '&value=' + pathName[2],
        type: 'GET',
        success: function (response) {
            $("#classSimpleTemplate").tmpl(response).appendTo("#classSimpleList");
        },
        error: function (request, status, error) {
            alert("실패");
        }
    })
});