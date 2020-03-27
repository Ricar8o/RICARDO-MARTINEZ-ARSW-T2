/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.coronavirus.controllers;

import edu.eci.arsw.coronavirus.services.CoronavirusStatsServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ricardo Martinez
 */
@RestController
@RequestMapping(value = "/coronavirusStats")
public class CoronavirusAPIController {
    @Autowired
    CoronavirusStatsServices css = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllStats() {
        try {
            return new ResponseEntity<>(css.getAllStadistics(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(path ="/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> GetStatsCountry(@PathVariable ("country") String country){
        try {
            return new ResponseEntity<>(css.getCountryStadistics(country),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    }
    @RequestMapping(path ="/{country}/provinces",method = RequestMethod.GET)
    public ResponseEntity<?> GetCountryProvincesStats(@PathVariable ("country") String country){
        try {
            return new ResponseEntity<>(css.getCountryProvinces(country),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(CoronavirusAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }        
    }
}