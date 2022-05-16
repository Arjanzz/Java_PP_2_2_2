package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("CAR_1", 2020, 10000));
        cars.add(new Car("CAR_2", 2021, 20000));
        cars.add(new Car("CAR_3", 2022, 30000));
        cars.add(new Car("CAR_4", 2023, 40000));
        cars.add(new Car("CAR_5", 2024, 50000));
    }
    @Override
    public int countCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
