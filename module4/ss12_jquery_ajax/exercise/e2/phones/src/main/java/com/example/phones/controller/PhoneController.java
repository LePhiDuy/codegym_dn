package com.example.phones.controller;

import com.example.phones.model.Phone;
import com.example.phones.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartPhones")
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;
    @PostMapping
    public ResponseEntity<Phone> create(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("phones/list");
        modelAndView.addObject("phones", phoneService.findAll());
        return modelAndView;
    }
    @GetMapping
    public ResponseEntity<Iterable<Phone>> allPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> delete(@PathVariable Long id) {
        Optional<Phone> phone = phoneService.findById(id);
        if (!phone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.delete(id);
        return new ResponseEntity<>(phone.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Phone> find(@PathVariable Long id) {
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Phone> editPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }
}
