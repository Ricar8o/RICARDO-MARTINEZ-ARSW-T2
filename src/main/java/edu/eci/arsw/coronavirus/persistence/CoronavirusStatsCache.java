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

    public CoronavirusStatsCache(){
        estadisticas= new HashMap<String, CountryStat>();
    }

    public void setData(String country, CountryStat cs){
        estadisticas.put(country, cs);
    }

    public CountryStat getEstadisticas(String country){
        return estadisticas.get(country);
    }

    public HashMap<String, CountryStat> getEstadisticas(){
        return this.estadisticas;
    }

	public ArrayList<CountryStat> getList() {
        ArrayList<CountryStat> lista = new ArrayList<CountryStat>();
        for(CountryStat coun: estadisticas.values()){
            lista.add(coun);
        }
		return lista;
	}
    

}
