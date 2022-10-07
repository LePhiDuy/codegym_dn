package vn.codegym.student_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.student_management.dto.QuestionContentDto;
import vn.codegym.student_management.entity.QuestionContent;
import vn.codegym.student_management.service.IQuestionTypeService;
import vn.codegym.student_management.service.IQuestionContentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/question")
public class QuestionContentController {
    @Autowired
    private IQuestionContentService questionContentService;
    @Autowired
    private IQuestionTypeService questionTypeService;

    @GetMapping("")
    public String view(@PageableDefault(value = 3, sort = "status", direction = Sort.Direction.ASC) Pageable pageable, Model model,
                       @RequestParam(defaultValue = "") String tittleSearch) {
        model.addAttribute("questionContents", questionContentService.findAll(pageable));
        //model.addAttribute("questionContents", questionContentService.findQuestionContentByTittle(tittleSearch, pageable));
        model.addAttribute("questionContentDto", new QuestionContentDto());
        model.addAttribute("questionType", questionTypeService.findAll());
        return "content/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        questionContentService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/question";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("questionContentDto", new QuestionContentDto());
        model.addAttribute("questionTypes", questionTypeService.findAll());
        return "/content/create";
    }

    @PostMapping("/save")
    public String save(@Valid QuestionContentDto questionContentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/content/create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        questionContentService.save(questionContent);
        return "redirect:/question";
    }
//    @GetMapping("/search")
//    public String search(@PageableDefault(value = 3, sort = "status", direction = Sort.Direction.ASC) Pageable pageable, Model model,
//                         @RequestParam(defaultValue = "") String tittleSearch, @RequestParam(defaultValue = "") String typeSearch) {
//        if (tittleSearch != "" && typeSearch == "") {
//            model.addAttribute("questionContents", questionContentService.findQuestionContentByTittle(tittleSearch, pageable));
//        }
//        model.addAttribute("questionContentDto", new QuestionContentDto());
//        model.addAttribute("questionType", questionTypeService.findAll());
//        return "content/list";
//    }
}
