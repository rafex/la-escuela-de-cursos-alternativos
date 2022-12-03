package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.Car;

public interface CarService {

    /**
     * Retrieve all cars in the catalog.
     *
     * @return all cars
     */
    public List<Car> findAll();

    /**
     * search cars according to keyword in model and make.
     *
     * @param keyword for search
     * @return list of car that match the keyword
     */
    public List<Car> search(String keyword);
}
