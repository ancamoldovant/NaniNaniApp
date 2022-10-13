package NaniNaniApp.NaniNaniApp.controller;

import NaniNaniApp.NaniNaniApp.model.Child;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@RequestMapping("NaniNani")
public class ChildController {
    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }
    @GetMapping("/add")
    public String addChildrenForm(Model model) {
        return "addForm";
    }
    @PostMapping("/add")
    public RedirectView addChildren (Model model,
                                     @RequestParam("name")String name,
                                     @RequestParam String dateOfBirth) {
        Child addedDog = new Child(UUID.randomUUID(), name, LocalDate.parse(dateOfBirth));
        return new RedirectView("/NaniNani/add/");
    }
}
