package edu.eci.arsw.coronavirus.services;

import java.util.ArrayList;

import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.coronavirus.model.CountryStat;

/**
 * @author Ricardo Martinez
 */
public interface CoronavirusStatsServices {
	/**
	 * Metodo que retorna las estadisticas de todos los paises.
	 * @return
	 * @throws UnirestException
	 */
	public ArrayList<CountryStat> getAllStadistics() throws UnirestException;
	/**
	 * Metodo que retorna las estadisticas de un pais. 
	 * @param country Nombre del pais
	 * @return
	 * @throws UnirestException
	 */
	public CountryStat getCountryStadistics(String country) throws UnirestException;
	/**
	 * Metodo que retorna todas las provincias de un pais.
	 * @param country Nombre del pais.
	 * @throws UnirestException
	 */
	public ArrayList<CountryStat> getCountryProvinces(String country) throws UnirestException;


}
