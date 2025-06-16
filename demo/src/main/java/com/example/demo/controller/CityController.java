package com.example.demo.controller;

import com.example.demo.dao.CityDao;
import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {


    private CityDao cityDao;

    @Autowired
    public CityController(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    // get endpoint - url/hi
    @GetMapping("hi")
    public String quickExample() {
        return "Helloooo";
    }

    @GetMapping("hi/{name}")
    public String personalizedExample(@PathVariable String name) {
        return "Hi..." + name;
    }

    @GetMapping
    public List<City> getCities() {
        return cityDao.getAllCities();
    }
}
