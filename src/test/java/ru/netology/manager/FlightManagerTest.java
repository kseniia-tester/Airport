package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {

    FlightRepository flightsRepository = new FlightRepository();
    FlightManager flightsManager = new FlightManager(flightsRepository);

    Flight likeTicket1 = new Flight(0, 1000, "SvN", "BGN", 60);
    Flight likeTicket2 = new Flight(1, 3000, "svn", "bgn", 112);
    Flight likeTicket3 = new Flight(2, 780, "GFH", "FRD", 78);
    Flight likeTicket4 = new Flight(3, 900, "SVN", "BGN", 90);
    Flight likeTicket5 = new Flight(4, 1200, "BGN", "SVN", 100);
    Flight likeTicket6 = new Flight(5, 2000, "SVN", "BGN", 120);

    @Test
    void findMany() {
        flightsManager.add(likeTicket1);
        flightsManager.add(likeTicket2);
        flightsManager.add(likeTicket3);
        flightsManager.add(likeTicket4);
        flightsManager.add(likeTicket5);
        flightsManager.add(likeTicket6);

        assertArrayEquals(new Flight[]{likeTicket4, likeTicket1, likeTicket6, likeTicket2}, flightsManager.findAll("svn", "bgn"));
    }

    @Test
    void findOne() {
        flightsManager.add(likeTicket1);
        flightsManager.add(likeTicket2);
        flightsManager.add(likeTicket3);
        flightsManager.add(likeTicket4);
        flightsManager.add(likeTicket5);
        flightsManager.add(likeTicket6);

        assertArrayEquals(new Flight[]{likeTicket3}, flightsManager.findAll("GFH", "FRD"));
    }

    @Test
    void ReportException() {
        flightsManager.add(likeTicket1);
        flightsManager.add(likeTicket2);
        flightsManager.add(likeTicket3);
        flightsManager.add(likeTicket4);
        flightsManager.add(likeTicket5);
        flightsManager.add(likeTicket6);

        assertArrayEquals(new Flight[]{}, flightsManager.findAll("VNO", "ART"));
    }
}


