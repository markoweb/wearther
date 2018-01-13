$('#search-btn').on('click', function() {
    var token = $('#search-input').val();
    $.ajax({
        url: 'http://localhost:8080/owm/weather',
        data: {token: token}
    }).done(function(data, textStatus, jqXHR) {
        $('.result').html(preRenderItem(data));
    }).fail(function(jqXHR, textStatus, errorThrown) {
       $('.result').html('');
   });
});

function preRenderItem(data) {
    var item = '';
    item += '<div class="row">';

    item += '<div class="col-md-1">';
    item += '<image src="http://openweathermap.org/img/w/' + data.weather.icon + '.png" />';
    item += '</div>';

    item += '<div class="col-md-10">';

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

    item += '</div>';

    return item;
};

function formatUnit(unit) {
    switch (unit) {
        case 'kelvin':
         return "°F";
         break;
    default:
        return "°C";
    }
}
