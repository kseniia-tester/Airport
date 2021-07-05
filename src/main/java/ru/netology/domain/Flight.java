package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Flight implements Comparable<Flight> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    public int compareTo(Flight o) {
        return this.price - o.price;
    }
}