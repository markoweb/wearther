$("#search-country-input").on("blur", function() {
    $("#search-city-input").val('');
    var token = $("#search-country-input").val();
    $.ajax({
        url: "http://localhost:8080/rws/city",
        data: {country: token}
    }).done(function(data, textStatus, jqXHR) {
        $("#search-city-input").autocomplete({
            source: data,
            delay: 0,
            minLength: 0
        });
    }).fail(function(jqXHR, textStatus, errorThrown) {
        $('#search-city-input').autocomplete({
            source: {}
        });
    });
});

$("#search-btn").on("click", function() {
    var country = $("#search-country-input").val();
    var city = $("#search-city-input").val();
    $.ajax({
        url: "http://localhost:8080/rws/weather",
        data: {country: country, city: city}
    }).done(function(data, textStatus, jqXHR) {
        $(".result").text(data)
    }).fail(function(jqXHR, textStatus, errorThrown) {
      $('.result').text(textStatus);
    });
});

