package ru.netology.manager;


import ru.netology.domain.Flights;
import ru.netology.repository.FlightsRepository;

import java.util.Arrays;
import java.util.Locale;

public class FlightsManager {
    private FlightsRepository flightsRepository;

    FlightsManager(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public void add(Flights flights) {
        flightsRepository.save(flights);
    }

    public Flights[] findAll(String from, String to) {
        Flights[] result = new Flights[0];
        for (Flights flights: flightsRepository.findAll()) {
            if (flights.getAirportFrom().equalsIgnoreCase(from) & flights.getAirportTo().equalsIgnoreCase(to)) {
                Flights[] tmp = new Flights[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flights;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}