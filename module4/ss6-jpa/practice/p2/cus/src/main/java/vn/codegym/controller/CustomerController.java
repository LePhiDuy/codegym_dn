package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.ICustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public ModelAndView list() {
        return new ModelAndView("list", "customers", customerService.findAll());
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Customer customer) {
        //customerService.save(customer);
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }
    @PostMapping("delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }

}
