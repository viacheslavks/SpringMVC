package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", 3, "red"));
        cars.add(new Car("BMW", 5, "blue"));
        cars.add(new Car("TaGaz", 346, "green"));
        cars.add(new Car("Vaz", 1, "white"));
        cars.add(new Car("Nissan", 66, "yellow"));
    }

    @Override
    public List<Car> list() {
        return cars;
    }

    @Override
    public List<Car> show(int count) {
        if (Integer.valueOf(count) == null) {
            return cars;
        } else if ((count == 0) || count >= 5) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
