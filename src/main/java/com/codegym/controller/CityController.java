package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("citys")
public class CityController {
    @Autowired
    private ICityService<City> cityService;
    @GetMapping("")
    private ResponseEntity<List<City>> getAll(){
        List<City> cityList = cityService.findAll();
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    private ResponseEntity<String> edit(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.save(city);
        return new ResponseEntity<>("Sua thanh cong", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cityService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<City> detail(@PathVariable Long id) {
        City city = cityService.findById(id).get();
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
}
