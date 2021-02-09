package com.hkg.micronaut.airport.service;

import com.hkg.micronaut.airport.entity.Airport;
import com.hkg.micronaut.airport.repository.AirportRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Locale;

@Singleton
public class AirportService {

    @Inject
    AirportRepository repository;

    /**
     *
     * @return
     */
    public Iterable<Airport> getAllAirpots() {
        return repository.findAll();
    }

    /**
     *
     */
    public Airport getAirportByCode(String airportCode) {
        return repository.findByAirportCode(airportCode.toUpperCase());
    }

    /**
     *
     * @param airport
     * @return
     */
    public Airport saveOrUpdate(Airport airport) {
        Airport airportSaved = null;

        if (airport.getId() != null &&
        repository.existsById(airport.getId())) {

            airportSaved = repository.update(airport);
        } else {
            airportSaved = repository.save(airport);
        }

        return airportSaved;
    }

    /**
     *
     * @param airportId
     */
    public void deleteAirport(Long airportId) {
        repository.deleteById(airportId);
    }
}
