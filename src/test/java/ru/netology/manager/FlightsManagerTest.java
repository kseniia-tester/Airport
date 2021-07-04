package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Flights;
import ru.netology.repository.FlightsRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlyChoiceManagerTest {

    FlightsRepository flightsRepository = new FlightsRepository();
    FlightsManager flightsManager = new FlightsManager(flightsRepository);

    Flights likeTicket1 = new Flights(0, 1000, "SvN", "BGN", 60);
    Flights likeTicket2 = new Flights(1, 3000, "svn", "bgn", 112);
    Flights likeTicket3 = new Flights(2, 780, "GFH", "FRD", 78);
    Flights likeTicket4 = new Flights(3, 900, "SVN", "BGN", 90);
    Flights likeTicket5 = new Flights(4, 1200, "BGN", "SVN", 100);
    Flights likeTicket6 = new Flights(5, 2000, "SVN", "BGN", 120);

    @Test
    void findMany() {
        flightsManager.add(likeTicket1);
        flightsManager.add(likeTicket2);
        flightsManager.add(likeTicket3);
        flightsManager.add(likeTicket4);
        flightsManager.add(likeTicket5);
        flightsManager.add(likeTicket6);

        assertArrayEquals(new Flights[]{likeTicket4, likeTicket1, likeTicket6,likeTicket2}, flightsManager.findAll("svn", "bgn"));
    }

    @Test
    void findOne() {
        flightsManager.add(likeTicket1);
        flightsManager.add(likeTicket2);
        flightsManager.add(likeTicket3);
        flightsManager.add(likeTicket4);
        flightsManager.add(likeTicket5);
        flightsManager.add(likeTicket6);

        assertArrayEquals(new Flights[]{likeTicket3}, flightsManager.findAll("GFH", "FRD"));
    }


}


