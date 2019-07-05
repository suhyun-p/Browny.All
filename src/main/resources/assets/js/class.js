$(document).ready(function () {

    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClassDetail?classNo=' + $.urlParam('classNo'),
        type: 'GET',
        success: function (response) {
            $("#classDetailTemplate").tmpl(response).appendTo("#classDetail");
        },
        error: function (request, status, error) {
            alert("실패");
        }
    })
});