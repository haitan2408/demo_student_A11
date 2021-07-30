package com.codegym.demo_a11.controller;

import com.codegym.demo_a11.model.entity.Student;
import com.codegym.demo_a11.model.service.IClassStudentService;
import com.codegym.demo_a11.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/student")
@Controller
public class StudentController {

    // Singleton
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassStudentService iClassStudentService;

    @GetMapping(value = {"/", "/list"})
    public ModelAndView goListStudent(@RequestParam(value = "page", defaultValue = "0")int page) {
        ModelAndView modelAndView = new ModelAndView("list_student");
        Sort sort = Sort.by("name").and(Sort.by("id")).ascending();// Nếu name trùng nhau thì sắp xêp theo date.
        Page<Student> studentList = iStudentService.findAll(PageRequest.of(page,2,sort));
        modelAndView.addObject("studentList", studentList);

        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam Integer idStudent, Model model) {
        model.addAttribute("studentObj",
                this.iStudentService.findById(idStudent));

        return "detail_student";
    }

    @GetMapping(value = "/detail/{idStudent}")
    public String goDetailStudentPV(@PathVariable Integer idStudent, Model model) {
        model.addAttribute("studentObj",
                this.iStudentService.findById(idStudent));

        return "detail_student";
    }

    @GetMapping(value = "/create")
    public String goCreateNewStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", iClassStudentService.findAll());
        return "create_student";
    }

    @PostMapping(value = "/create")
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        new Student().validate(student, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("listClass", iClassStudentService.findAll());
            return "create_student";
        }
        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg",
                "Create new successfully!");

        return "redirect:/student/list";
    }
}
