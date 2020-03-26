package edu.eci.arsw.coronavirus.services;

import java.util.HashMap;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.coronavirus.model.CountryStat;

/**
 * @author Ricardo Martinez
 */
public interface CoronavirusStatsServices {

	public HashMap<String, CountryStat> getAllStadistics() throws UnirestException;
	public CountryStat getCountryStadistics(String country) throws UnirestException;


}
