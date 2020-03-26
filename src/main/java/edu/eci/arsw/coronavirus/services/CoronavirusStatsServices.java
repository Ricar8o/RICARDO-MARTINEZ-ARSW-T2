package edu.eci.arsw.coronavirus.services;

import java.util.HashMap;

import edu.eci.arsw.coronavirus.model.CountryStat;

/**
 * @author Ricardo Martinez
 */
public interface CoronavirusStatsServices {

	public HashMap<String, CountryStat> getAllStadistics();

	public CountryStat getStadisticsCountry(String country);

}
