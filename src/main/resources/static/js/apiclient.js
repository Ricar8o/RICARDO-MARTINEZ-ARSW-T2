var apiclient = (function () {
    return {
        getAllStats: function(callback) {   




            $.get('https://ricardo-martinez-arsw-t2.herokuapp.com/coronavirusStats/' , function(CountryStats){
                callback(CountryStats)
            });
        },

        getCountryStats: function(country, callback) {
			$.get('https://ricardo-martinez-arsw-t2.herokuapp.com/coronavirusStats/' + country, function(CountryStat){
				callback(null, CountryStat)
			});
        },
    }
})();
