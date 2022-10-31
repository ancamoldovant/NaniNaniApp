package NaniNaniApp.NaniNaniApp.controller;

import NaniNaniApp.NaniNaniApp.model.*;
import NaniNaniApp.NaniNaniApp.repo.JpaChildRepository;
import NaniNaniApp.NaniNaniApp.repo.JpaChildWithSleepScheduleRepository;
import NaniNaniApp.NaniNaniApp.service.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.text.AttributedString;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("children")
public class ChildController {

    @Autowired
    public IAuthenticationFacade authenticationFacade;

    @Autowired
    public JpaChildRepository jpaChildRepository;
    @Autowired
    public JpaChildWithSleepScheduleRepository jpaChildWithSleepScheduleRepository;

    @GetMapping("/")
    public String naniNaniHomepage(Model model) {
        return "children/home";
    }

    @GetMapping(value = {"/add"})
    public String addChildForm(Model model) {
        return "children/addForm";
    }

    @PostMapping("/add")
    public RedirectView addChild(Model model,
                                 @RequestParam String name,
                                 @RequestParam String dateOfBirth) {
        Child addedChild = new Child(UUID.randomUUID(), name, LocalDate.parse(dateOfBirth));
        Authentication authentication = authenticationFacade.getAuthentication();
        addedChild.setUser(((CustomUserDetails) authentication.getPrincipal()).getUser());
        jpaChildRepository.saveAndFlush(addedChild);
        return new RedirectView("/children/list/");
    }

    @GetMapping(value = {"/list"})
    public String optimalSleepSchedule(Model model) {
        Authentication authentication = authenticationFacade.getAuthentication();
        User authenticatedUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        List<Child> allChildren = jpaChildRepository.findAllChildrenByUser(authenticatedUser);
        List<ChildWithSleepSchedule> childrenWithSleepSchedule = new ArrayList<>();
        for (Child child : allChildren) {
            OptimalSleepSchedule schedule = jpaChildWithSleepScheduleRepository.findByMonth(child.getMonths());
            ChildWithSleepSchedule childWithSleepSchedule = new ChildWithSleepSchedule(child, schedule);
            childrenWithSleepSchedule.add(childWithSleepSchedule);
        }
        model.addAttribute("childrenWithSleepSchedule", childrenWithSleepSchedule);
        return "children/list";
    }
    @GetMapping("list/delete/{id}")
    public RedirectView deleteChild(Model model, @PathVariable("id") UUID childId) {
        jpaChildRepository.deleteById(childId);
        return new RedirectView("/children/list");
    }
    @GetMapping("/personalizedSleepSchedule/{id}")
    public String personalizedSleepScheduleChild(Model model, @PathVariable("id") UUID childId) {

        return ("/children/personalizedSleepSchedule");
    }
    @PostMapping("/personalizedSleepSchedule")
    public RedirectView getPersonalizedSleepSchedule(Model model, @RequestParam String morningWakeUp){
        ChildWithPersonalizedSleepSchedule childPersonalized = new ChildWithPersonalizedSleepSchedule(LocalTime.parse(morningWakeUp));
        return new RedirectView("/children/personalizedSleepSchedule");
    }

}






