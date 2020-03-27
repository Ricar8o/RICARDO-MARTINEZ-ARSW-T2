package edu.eci.arsw.coronavirus.services.impl;

import java.util.ArrayList;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.coronavirus.model.CountryStat;
import edu.eci.arsw.coronavirus.persistence.CoronavirusStatsCache;
import edu.eci.arsw.coronavirus.services.CoronavirusStatsServices;
import edu.eci.arsw.coronavirus.services.HTTPConnectionService;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Ricardo Martinez
 */
@Service
public class CoronavirusStatsServicesImpl implements CoronavirusStatsServices {

    @Autowired
    HTTPConnectionService hcs;
    @Autowired
    CoronavirusStatsCache csc;
    

    @Override
    public ArrayList<CountryStat> getAllStadistics() throws UnirestException {
        JSONObject obj = new JSONObject(hcs.getAllStats()).getJSONObject("data");
        JSONArray array = obj.getJSONArray("covid19Stats");
        for(int i = 0; i<array.length();i++){
            JSONObject json = array.getJSONObject(i);
            String country = json.getString("country");
            CountryStat countrystat = getCountryStadistics(country);
        }
        ArrayList<CountryStat> estadisticas = csc.getList();;
        return estadisticas;
    }

    @Override
    public CountryStat getCountryStadistics(String country) throws UnirestException {
        //System.out.println(hcs.getCountryStats(country));
        CountryStat cs =csc.getEstadisticas(country);
        if (cs==null){
            JSONObject obj = new JSONObject(hcs.getCountryStats(country)).getJSONObject("data");
            JSONArray array = obj.getJSONArray("covid19Stats");
            cs = getCountryStat(array,country);
            csc.setData(country, cs);
        }
        
        return cs;
    }
    /**
     * Metodo que convierte los datos de un json en las estadisticas de un pais
     * @param array Un arreglo de json con informacion de un pais.
     * @param country Nombre del pais.
     * @return Las estadistacas de un pais.
     */
    private CountryStat getCountryStat(JSONArray array,String country){
        int deaths = 0;
        int infected =0;
        int cured = 0;
        ArrayList<CountryStat> provincias = new ArrayList<CountryStat>();
        for(int i = 0; i<array.length();i++){
            JSONObject json = array.getJSONObject(i);
            int dea = json.getInt("deaths");
            int inf=json.getInt("confirmed");
            int cur= json.getInt("recovered");
            String province = json.getString("province");
            
            deaths += dea;
            infected +=inf;
            cured += cur;
            CountryStat provinceStat = new CountryStat(province,dea,inf,cur);
            provincias.add(provinceStat);
        }
        CountryStat cs = new CountryStat(country,deaths,infected,cured,provincias);
        return cs;
    }

    public ArrayList<CountryStat> getCountryProvinces(String country) throws UnirestException{
        CountryStat cs =getCountryStadistics(country);
        return cs.getProvinces();
    };

}