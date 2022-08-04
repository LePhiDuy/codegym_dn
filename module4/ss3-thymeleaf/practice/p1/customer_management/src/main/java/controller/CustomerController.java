package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repository.ICustomerService;
import repository.impl.CustomerServiceImpl;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }
    @GetMapping("create")
    public String showPageCreate(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }
    @PostMapping("save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) Math.random() * 100);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Add new customer success");
        return "redirect:/customer";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute(customerService.findById(id));
        return "view";
    }
}
