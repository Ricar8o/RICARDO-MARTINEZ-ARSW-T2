package edu.eci.arsw.coronavirus.services.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.coronavirus.model.CountryStat;
import edu.eci.arsw.coronavirus.persistence.CoronavirusStatsCache;
import edu.eci.arsw.coronavirus.services.CoronavirusStatsServices;
import edu.eci.arsw.coronavirus.services.HTTPConnectionService;

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
    public HashMap<String, CountryStat>getAllStadistics() {
        return null;
    }

    @Override
    public CountryStat getStadisticsCountry(String country) {
        return null;
    }
    
}