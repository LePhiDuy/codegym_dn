package vn.codegym.exam_module4.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.exam_module4.dto.AgreementDto;
import vn.codegym.exam_module4.entity.Agreement;
import vn.codegym.exam_module4.entity.Hostel;
import vn.codegym.exam_module4.service.IAgreementService;
import vn.codegym.exam_module4.service.IHostelService;

import java.util.List;

@Controller
@RequestMapping("/agreement")
public class AgreementController {
    @Autowired
    private IAgreementService agreementService;
    @Autowired
    private IHostelService hostelService;
    @ModelAttribute("allHostel")
    public List<Hostel> allHostel() {
        return hostelService.findAll();
    }
    @GetMapping("")
    public String view(Model model) {
        model.addAttribute("agreements", agreementService.findAll());
        model.addAttribute("agreementDto", new AgreementDto());
        model.addAttribute("hostelFree", hostelService.findHostelFree());
        return "/agreement/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("agreementDto", new AgreementDto());
        model.addAttribute("hostelFree", hostelService.findHostelFree());
        model.addAttribute("tittle", "Add new Agreement");
        return "/agreement/create";
    }
    @GetMapping("edit/{id}")
    public String showFormEdit(Model model, @PathVariable String id) {
        AgreementDto agreementDto = new AgreementDto();
        BeanUtils.copyProperties(agreementService.findById(id).get(), agreementDto);
        model.addAttribute("agreementDto", agreementDto);
        model.addAttribute("hostelFree", hostelService.findHostelFree());
        model.addAttribute("tittle", "Edit Agreement");
        return "/agreement/create";
    }
    @PostMapping("/save")
    public String save(@Validated AgreementDto agreementDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/agreement/create";
        }
        Agreement agreement = new Agreement();
        BeanUtils.copyProperties(agreementDto, agreement);
        agreement.getHostel().setStatus(false);
        agreementService.save(agreement);
        return "redirect:/agreement";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes) {
        agreementService.findById(id).get().getHostel().setStatus(true);
        agreementService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete Successfully");
        return "redirect:/agreement";
    }
}
