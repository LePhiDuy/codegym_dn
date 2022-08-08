package vn.codegym.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.customer_management.model.Customer;
import vn.codegym.customer_management.model.Province;
import vn.codegym.customer_management.service.ICustomerService;
import vn.codegym.customer_management.service.IProvinceService;

import java.util.Optional;

@Controller
@RequestMapping("province")
public class ProvinceController {
    @Autowired
    IProvinceService provinceService;
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public ModelAndView list() {
        return new ModelAndView("provinces/list","provinces", provinceService.findAll());
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("province", new Province());
        return "provinces/create";
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("provinces/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("province", provinceService.findById(id).get());
        return "provinces/edit";
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("provinces/create");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("province", provinceService.findById(id).get());
        Optional<Province> provinceOptional = provinceService.findById(id);
        if (!provinceOptional.isPresent()) {
            return "error.404";
        }
        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());
        model.addAttribute("customers", customers);
        return "provinces/view";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("province", provinceService.findById(id).get());
        return "provinces/delete";
    }
    @PostMapping("delete")
    public String deleteCustomer(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:/province";
    }
}

