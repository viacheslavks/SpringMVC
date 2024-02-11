package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImp carServiceImp;

    @Autowired
    public CarController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("cars", carServiceImp.list());
        return "cars/list";
    }

    @GetMapping(params = "count")
    public String show(@RequestParam("count") Integer count, Model model) {
        model.addAttribute("cars", carServiceImp.show(count));
        return "cars/show";
    }
}
