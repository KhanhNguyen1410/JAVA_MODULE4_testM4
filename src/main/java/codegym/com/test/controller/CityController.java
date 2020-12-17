package codegym.com.test.controller;

import codegym.com.test.model.City;
import codegym.com.test.model.Country;
import codegym.com.test.repository.CountryRepository;
import codegym.com.test.repository.ICityRepository;
import codegym.com.test.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CityController {
    @Autowired
    private ICityService iCityService;
    @Autowired
    private CountryRepository countryRepository;

    @ModelAttribute("countries")
    public Iterable<Country> listCountry(){
        return countryRepository.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listAll(Pageable pageable){
        Page<City> cities = iCityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }
    @GetMapping("/create-city")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");

        if (!bindingResult.hasFieldErrors()) {
            iCityService.save(city);
            modelAndView.addObject("city", new City());
            modelAndView.addObject("message", "them thanh cong");
        }
        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("/details");
        City city = iCityService.findAllById(id);
        modelAndView.addObject("city", city);
        return  modelAndView;
    }
    @GetMapping("/delete-city/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/delete");

        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView modelAndView(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("/list");
        iCityService.remove(id);
        modelAndView.addObject("message", "xoa thanh cong");
        return modelAndView;
    }
    @GetMapping("/edit-city/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        City city = iCityService.findAllById(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute City city){
        ModelAndView modelAndView = new ModelAndView("/edit");
        iCityService.save(city);
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "update thanh cong");
        return modelAndView;
    }
}
