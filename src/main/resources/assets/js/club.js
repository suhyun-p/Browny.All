$(document).ready(function () {
    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    }

    // Instructor Info
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClubInfo?clubNo=' +  $.urlParam('clubNo'),
        type: 'GET',
        success: function (response) {
            // $("#instructorTemplate").tmpl(response).appendTo("#instructorInfo");
            $("#clubName").text("#" + response.clubName);
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });

    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClassListByClub?clubNo=' +  $.urlParam('clubNo'),
        type: 'GET',
        success: function (response) {
            $("#classSimpleTemplate").tmpl(response).appendTo("#classSimpleList");
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });

    /*
    // In Progress


    // In Closed
    $.ajax({
        contentType: 'application/json',
        dataType: 'json',
        // data: JSON.stringify(data),
        url: '/getClosedClassListByInstructor?instructorNo=' +  $.urlParam('instructorNo'),
        type: 'GET',
        success: function (response) {
            $("#classSimpleTemplate").tmpl(response).appendTo("#classClosedSimpleListByInstructor");
        },
        error: function (request, status, error) {
            alert("실패");
        }
    });*/
});