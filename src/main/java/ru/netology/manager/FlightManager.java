package ru.netology.manager;


import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

public class FlightManager {
    private FlightRepository flightsRepository;

    FlightManager(FlightRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public void add(Flight flights) {
        flightsRepository.save(flights);
    }

    public Flight[] findAll(String from, String to) {
        Flight[] result = new Flight[0];
        for (Flight flight: flightsRepository.findAll()) {
            if (flight.getAirportFrom().equalsIgnoreCase(from) && flight.getAirportTo().equalsIgnoreCase(to)) {
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}