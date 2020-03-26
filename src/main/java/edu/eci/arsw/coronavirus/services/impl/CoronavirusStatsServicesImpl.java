package edu.eci.arsw.coronavirus.services.impl;

import java.util.HashMap;

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
    public HashMap<String, CountryStat> getAllStadistics() throws UnirestException {
        System.out.println(hcs.getAllStats());
        return null;
    }

    @Override
    public CountryStat getCountryStadistics(String country) throws UnirestException {
        //System.out.println(hcs.getCountryStats(country));
        JSONObject obj = new JSONObject(hcs.getCountryStats(country)).getJSONObject("data");
        JSONArray array = obj.getJSONArray("covid19Stats");
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
        System.out.println(cs);
        return cs;
    }
    
}