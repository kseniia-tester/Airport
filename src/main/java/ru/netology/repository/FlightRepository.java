package ru.netology.repository;

import ru.netology.domain.Flight;
import ru.netology.exception.NotFoundException;

public class FlightRepository {
    private Flight[] items = new Flight[0];

    public void save(Flight item) {
        int length = items.length + 1;
        Flight[] tmp = new Flight[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Flight[] findAll() {
        return items;
    }

    public Flight findById(int id) {
        for (Flight item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id = " + id + " не найден!");
        }
        int length = items.length - 1;
        Flight[] tmp = new Flight[length];
        int index = 0;
        for (Flight item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}