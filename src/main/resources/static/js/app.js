var apiclient = apiclient;
var app = (function () {


    var loadTable = function(stats) {
          $("#stats").append(
          bstats.map(function(stat){
            return "<tr><td>" + stat.country + "</td><td>" + stat.deaths + "</td><td>" +stat.infected + "</td><td>" + stat.cured + "<tr><td>"
            })  
          );
        }
    var iniciar = function(){
        apiclient.getAllStats(loadTable);
    }

    return{
        table : loadTable,
        init: iniciar
    };

})();