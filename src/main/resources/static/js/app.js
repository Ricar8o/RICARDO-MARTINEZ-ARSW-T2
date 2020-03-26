var apiclient = apiclient;
var app = (function () {

    var loadTable = function(stats) {
          $("#stats").append(
          stats.map(function(stat){
            return "<tr><td>" + stat.country + "</td><td>" + stat.deaths + "</td><td>" +stat.infected + "</td><td>" + stat.cured 
            })  
          );
        }

    var loadTable = function(stats) {
        $("#ProvStats").append(
        stats.map(function(stat){
            return "<tr><td>" + stat.country + "</td><td>" + stat.deaths + "</td><td>" +stat.infected + "</td><td>" + stat.cured 
            })  
        );
    }
    var iniciar = function(){
        apiclient.getAllStats(loadTable);
        apiclient.getProvinceStats("Canada",loadTable2)
    }

    return{
        table : loadTable,
        init: iniciar
    };

})();