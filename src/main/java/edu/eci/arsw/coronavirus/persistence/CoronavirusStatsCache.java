package edu.eci.arsw.coronavirus.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.coronavirus.model.CountryStat;

/**
 * @author Ricardo Martinez
 */
@Service
public class CoronavirusStatsCache {

    private HashMap<String, CountryStat> estadisticas;
    /**
     * Constructor CoronavirusStatsCache
     */
    public CoronavirusStatsCache(){
        estadisticas= new HashMap<String, CountryStat>();
    }

    /**
     * Agregar una ciudad y sus estadisticas.
     * @param country Pais (nombre).
     * @param cs Estadisticas de coronavirus para el pais.
     */
    public void setData(String country, CountryStat cs){
        estadisticas.put(country, cs);
    }

    /**
     * Retorna las estadisticas de un pais.
     * @param country Nombre del pais.
     * @return Estadisticas de coronavirus del pais.
     */
    public CountryStat getEstadisticas(String country){
        return estadisticas.get(country);
    }
    /**
     * Retorna todas las estadisticas almacenadas y el pais.
     * @return
     */
    public HashMap<String, CountryStat> getEstadisticas(){
        return this.estadisticas;
    }
    /**
     * Retorna todas las estadisticas almacenadas
     * @return
     */
	public ArrayList<CountryStat> getList() {
        ArrayList<CountryStat> lista = new ArrayList<CountryStat>();
        for(CountryStat coun: estadisticas.values()){
            lista.add(coun);
        }
		return lista;
	}
    

}
