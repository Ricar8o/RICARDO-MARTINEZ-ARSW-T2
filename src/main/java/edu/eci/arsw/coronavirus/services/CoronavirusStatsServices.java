package edu.eci.arsw.coronavirus.services;

import java.util.ArrayList;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.coronavirus.model.CountryStat;

/**
 * @author Ricardo Martinez
 */
public interface CoronavirusStatsServices {

	public ArrayList<CountryStat> getAllStadistics() throws UnirestException;
	public CountryStat getCountryStadistics(String country) throws UnirestException;
	public ArrayList<CountryStat> getCountryProvinces(String country) throws UnirestException;


}
