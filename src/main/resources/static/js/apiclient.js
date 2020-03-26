var apiclient = (function () {
    return {
        getAllStats: function(callback) {   




            $.get('http://localhost:8080/coronavirusStats/' , function(CountryStats){
                callback(CountryStats)
            });
        },

        getCountryStats: function(country, callback) {
			$.get('http://localhost:8080/coronavirusStats/' + country, function(CountryStat){
				callback(null, CountryStat)
			});
        },
    }
})();
