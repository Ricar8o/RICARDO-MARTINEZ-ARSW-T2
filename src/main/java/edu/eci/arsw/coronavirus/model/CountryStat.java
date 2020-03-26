package edu.eci.arsw.coronavirus.model;

import java.util.ArrayList;

public class CountryStat {

    String country;
    int deaths;
    int infected;
    int cured;
    ArrayList<CountryStat> provincias;

    public CountryStat() {

    }
    public CountryStat(String country, int deaths, int infected ,int cured){
        this.country = country;
        this.deaths = deaths;
        this.infected = infected;
        this.cured = cured;
    }
    public CountryStat(String country, int deaths, int infected ,int cured, ArrayList<CountryStat> provincias){
        this.country = country;
        this.deaths = deaths;
        this.infected = infected;
        this.cured = cured;
        this.provincias = provincias;
    }

    public String getCountry(){return this.country;}
    public int getDeaths(){return this.deaths;}
    public int getInfected(){return this.infected;}
    public int getCured(){return this.cured;}

    public void setCountry(String country){this.country=country;}
    public void setDeaths(int deaths){this.deaths=deaths;}
    public void setInfected(int infected){this.infected=infected;}
    public void setCured(int cured){this.cured=cured;}

	public ArrayList<CountryStat> getProvinces() {
		return this.provincias;
    }
    public void setProvinces(ArrayList<CountryStat> provincias) {
		this.provincias= provincias;
	}

}