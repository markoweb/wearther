$("#search-btn").on("click", function() {
    var token = $("#search-input").val();
    $.ajax({
        url: "http://localhost:8080/search",
        data: {q : token }
    }).done(function(data, textStatus, jqXHR) {
       $('.temperature').text(data.temperature);
       $('.description').text(data.description);
    }).fail(function(jqXHR, textStatus, errorThrown) {
        $('.temperature').text("");
        $('.description').text(textStatus);
    });
});
