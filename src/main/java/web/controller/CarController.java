package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> carsToShow = new ArrayList<>();
        int countToShow = count > carService.countCars() ? carService.countCars() : count;
        for (int i = 0; i < countToShow; i++) {
            carsToShow.add(carService.getCars().get(i));
        }
        model.addAttribute("cars", carsToShow);
        return "cars";
    }
}
