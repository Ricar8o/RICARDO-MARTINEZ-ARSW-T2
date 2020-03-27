var apiclient = apiclient;
var app = (function () {

    var loadTable = function(stats) {
          $("#stats").append(
          stats.map(function(stat){
            return "<tr><td>" + stat.country + "</td><td>" + stat.deaths + "</td><td>" +stat.infected + "</td><td>" + stat.cured +"</tr></td>"
            })  
          );
          $('tr').click(function(){
            var name = this.cells[0].textContent;
            apiclient.getProvinceStats(name,loadTable2);
            $("#CountryN").text(name);
          });
        }

    var loadTable2 = function(stats) {
        $("#ProvStats").find("tr:gt(0)").remove();
        $("#ProvStats").append(
        stats.map(function(stat){
            return "<tr><td>" + stat.country + "</td><td>" + stat.deaths + "</td><td>" +stat.infected + "</td><td>" + stat.cured 
            })  
        );
        
    }
    
    var iniciar = function(){
        apiclient.getAllStats(loadTable);
        apiclient.getProvinceStats("Canada",loadTable2);
    }

    return{
        table : loadTable,
        init: iniciar
    };

})();