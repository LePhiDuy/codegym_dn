package vn.codegym.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    IProvinceService provinceService;

    @GetMapping("")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findCustomersByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("customers/list","customers", customers);
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/create";
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "customers/edit";
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "customers/view";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "customers/delete";
    }
    @PostMapping("delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }
    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

}
