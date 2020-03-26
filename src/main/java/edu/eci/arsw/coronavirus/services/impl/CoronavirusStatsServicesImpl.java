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
        ArrayList<CountryStat> estadisticas = new ArrayList<CountryStat>();
        for(int i = 0; i<array.length();i++){
            JSONObject json = array.getJSONObject(i);
            String country = json.getString("country");
            CountryStat countrystat = getCountryStadistics(country);
            estadisticas.add(countrystat);
        }
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

    private CountryStat getCountryStat(JSONArray array,String country){
        int deaths = 0;
        int infected =0;
        int cured = 0;
        for(int i = 0; i<array.length();i++){
            JSONObject json = array.getJSONObject(i);
            deaths += json.getInt("deaths");
            infected +=json.getInt("confirmed");
            cured += json.getInt("recovered");
        }
        CountryStat cs = new CountryStat(country,deaths,infected,cured);
        return cs;
    }

}