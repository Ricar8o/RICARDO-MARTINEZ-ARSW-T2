var apiclient = (function () {
    return {
        getAllStats: function(callback) {   
            $.get('https://ricardo-martinez-arsw-t2.herokuapp.com/coronavirusStats/' , function(CountryStats){
                callback(CountryStats)
            });
        },

        getCountryStats: function(country, callback) {
			$.get('https://ricardo-martinez-arsw-t2.herokuapp.com/coronavirusStats/' + country, function(CountryStat){
				callback(CountryStat)
			});
        },

        getProvinceStats: function(country, callback) {
			$.get('https://ricardo-martinez-arsw-t2.herokuapp.com/coronavirusStats/' + country+'/provinces', function(CountryStat){
				callback(CountryStat)
			});
        },
    }
})();
