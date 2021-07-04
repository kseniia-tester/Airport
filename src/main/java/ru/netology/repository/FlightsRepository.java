package ru.netology.repository;

import ru.netology.domain.Flights;
import ru.netology.exception.NotFoundException;

public class FlightsRepository {
    private Flights[] items = new Flights[0];

    public void save(Flights item) {
        int length = items.length + 1;
        Flights[] tmp = new Flights[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Flights[] findAll() {
        return items;
    }

    public Flights findById(int id) {
        for (Flights item : items) {
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
        Flights[] tmp = new Flights[length];
        int index = 0;
        for (Flights item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}