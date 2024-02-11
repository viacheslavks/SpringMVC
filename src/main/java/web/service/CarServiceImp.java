package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDaoImp;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarDaoImp carDaoImp;

    public CarServiceImp(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    @Override
    public List<Car> list() {
        return carDaoImp.list();
    }

    @Override
    public List<Car> show(int count) {
        return carDaoImp.show(count);
    }

}

