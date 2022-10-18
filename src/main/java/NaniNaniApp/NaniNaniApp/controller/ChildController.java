package NaniNaniApp.NaniNaniApp.controller;

import NaniNaniApp.NaniNaniApp.model.Child;
import NaniNaniApp.NaniNaniApp.repo.JpaChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("children")
public class ChildController {
    @Autowired
    public JpaChildRepository jpaChildRepository;
    @GetMapping("/")
    public String naniNaniHomepage(){
        return "children/home";
    }
    @GetMapping (value ={"/list"})
    public String optimalSleepSchedule(Model model){
        model.addAttribute("children", jpaChildRepository.findAll());
        return "children/list";
    }

    @GetMapping (value = {"/add"})
    public String addChildForm(Model model){
        return "children/addForm";
    }
   @PostMapping("/add")
   public RedirectView addChild(Model model,
                          @RequestParam String name,
                          @RequestParam String dateOfBirth){
       Child addedChild = new Child(UUID.randomUUID(), name, LocalDate.parse(dateOfBirth));
     // model.addAttribute("OSS", "Optimal sleep schedule for" + name + "is");
       jpaChildRepository.saveAndFlush(addedChild);
      return new RedirectView("/children/list/");
   }
}
