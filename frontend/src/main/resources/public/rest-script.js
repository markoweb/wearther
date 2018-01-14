$(document).ready(function() {
    renderFavourites();
});

$(document).on('click', '#search-btn', function() {
    var token = $('#search-input').val();
    $.ajax({
        url: 'http://localhost:8080/owm/weather',
        data: {token: token}
    }).done(function(data, textStatus, jqXHR) {
        $('.result').html(preRenderResultItem(data));
    }).fail(function(jqXHR, textStatus, errorThrown) {
       $('.result').html('');
    });
});

$(document).on('click', '#add-to-favourites', function(event) {
    var city = $(this).data('value');
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/owm/favourites',
        data: {city: city},
        dataType: 'json'
    }).always(function(data, textStatus, jqXHR) {
        renderFavourites()
    });
});

$(document).on('click', '.favourite-remove', function() {
    var id = $(this).data('value');
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/owm/favourites/' + id
    }).always(function(data, textStatus, jqXHR) {
        renderFavourites()
    });
});

$(document).on('click', '.favourite-search', function() {
    $('#search-input').val($(this).text());
    $('#search-btn').trigger('click');
});

function preRenderResultItem(data) {
    var item = '';
    item += '<div class="row">';

    item += '<div class="col-md-1">';
    item += '<image src="http://openweathermap.org/img/w/' + data.weather.icon + '.png" />';
    item += '</div>';

    item += '<div class="col-md-9">';

    item += '<div class="row">';

    item += '<p>';
    item += '<b>' + data.city.name + ', ' + data.city.country + '</b> ';
    item += '<image src="http://openweathermap.org/images/flags/' + data.city.country.toLowerCase() + '.png" /> ';
    item += '<b><i>' + data.clouds.name + '</i></b> ';
    item += '<b>' + '' + '</b>';
    item += '</p>';

    item += '<p>';
    item += '<span class="badge">' + data.temperature.value + ' ' + formatUnit(data.temperature.unit) + '</span> ';
    item += 'temperature from ' + data.temperature.min;
    item += ' to ' + data.temperature.max;
    item += ' ' + formatUnit(data.temperature.unit) + ', ';
    item += 'wind ' + data.wind.speed.value + ' m/s. ';
    item += 'clouds ' + data.clouds.value + ' %, ';
    item += data.pressure.value + ' ' + data.pressure.unit;
    item += '</p>';

    item += '<p>';
    item += 'Geo coords [' + data.city.coord.lat + ', ' + data.city.coord.lon + ']';
    item += '</p>';

    item += '</div>';

    item += '</div>';

    item += '<div class="col-md-2">';
    item += '<button type="button" class="btn btn-info" id="add-to-favourites"';
    item += 'data-value="' + data.city.name + '">Add to favourites</button>';
    item += '</div>';

    item += '</div>';

    return item;
};

function clearFavourites() {
    $('.favourite-item').remove();
}

function renderFavourites() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/owm/favourites'
    }).done(function(data, textStatus, jqXHR) {
        clearFavourites();
        $.each(data, function(i, obj) {
            $('.favourites-wrapper').append(preRenderFavouriteItem(obj));
        })
    }).fail(function(jqXHR, textStatus, errorThrown) {
        clearFavourites();
    });
}

function preRenderFavouriteItem(data) {
    var item = '';
    item += '<div class="row favourite-item" style="padding-bottom: 15px">';
    item += '<div class="btn-group pull-right" role="group">';
    item += '<button type="button" class="btn btn-default favourite-search">' + data.city + '</button>';
    item += '<button type="button" class="btn btn-default favourite-remove" data-value="' + data.id + '">';
    item += '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
    item += '</button>';
    item += '</div>';
    item += '</div>';

    return item;
}

function formatUnit(unit) {
    switch (unit) {
        case 'kelvin':
         return "°F";
         break;
    default:
        return "°C";
    }
}
