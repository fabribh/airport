package com.hkg.micronaut.airport.controller;

import com.hkg.micronaut.airport.entity.Airport;
import com.hkg.micronaut.airport.service.AirportService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/airport")
public class AirportController {

    /**
     *
     */
    @Inject
    AirportService service;

    /**
     *
     * @return
     */
    @Get("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Airport> getAll() {
        return service.getAllAirpots();
    }

    /**
     *
     * @param airportCode
     * @return
     */
    @Get("/find/{airportCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Airport getAirportByCode(String airportCode) {
        return service.getAirportByCode(airportCode);

    }

    /**
     *
     * @param airport
     * @return
     */
    @Post("/saveAirport")
    @Produces(MediaType.APPLICATION_JSON)
    public Airport saveOrUpdate(Airport airport) {
        return service.saveOrUpdate(airport);
    }

    /**
     *
     * @param airportId
     * @return
     */
    @Delete("/delete/{airportId}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse delete(Long airportId) {
        service.deleteAirport(airportId);
        return HttpResponse.ok();
    }
}
