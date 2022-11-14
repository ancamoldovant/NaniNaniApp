package NaniNaniApp.NaniNaniApp.controller;

import NaniNaniApp.NaniNaniApp.model.*;
import NaniNaniApp.NaniNaniApp.repo.JpaChildRepository;
import NaniNaniApp.NaniNaniApp.repo.JpaChildWithSleepScheduleRepository;
import NaniNaniApp.NaniNaniApp.repo.JpaInfoSleepScheduleRepository;
import NaniNaniApp.NaniNaniApp.service.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.time.LocalDate;
import java.util.*;

import static java.lang.String.format;

@Controller
@RequestMapping("children")

public class ChildController {

    @Autowired
    public IAuthenticationFacade authenticationFacade;

    @Autowired
    public JpaChildRepository jpaChildRepository;
    @Autowired
    public JpaChildWithSleepScheduleRepository jpaChildWithSleepScheduleRepository;

    @Autowired
    public JpaInfoSleepScheduleRepository jpaInfoSleepScheduleRepository;

    @GetMapping("/")
    public String getNaniNaniHomepage(Model model) {
        model.addAttribute("infoSleepSchedule", jpaInfoSleepScheduleRepository.findByTitle("About the application"));
        return "children/home";
    }
    @PostMapping("/")
    public String naniNaniHomepage(Model model) {
        model.addAttribute("infoSleepSchedule", jpaInfoSleepScheduleRepository.findByTitle("About the application"));
        return "children/home";
    }

    @GetMapping(value = {"/add"})
    public String addChildForm(Model model) {
        LocalDate now = LocalDate.now();
        model.addAttribute("now", now);
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
        return new RedirectView("/children/list/") ;
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
        model.addAttribute("infoSleepSchedule", jpaInfoSleepScheduleRepository.findAllByOrderByFromMonthAsc());
        return "children/list";
    }
    @GetMapping("list/delete/{id}")
    public RedirectView deleteChild(Model model, @PathVariable("id") UUID childId) {
        jpaChildRepository.deleteById(childId);
        return new RedirectView("/children/list");
    }
    @GetMapping("list/edit/{id}")
    public String editChildForm(Model model, @PathVariable("id") UUID childId) {
        Optional<Child> optionalChild = jpaChildRepository.findById(childId);
        Child child = optionalChild.get();
        model.addAttribute("child", child);
        return "children/editForm";
    }
    @PostMapping("/edit")
    public RedirectView addChildren(Model model,
                                    @RequestParam ("childId") UUID childId,
                                    @RequestParam ("name") String updatedName,
                                    @RequestParam ("dateOfBirth") String updatedDateOfBirth) {
        Optional<Child> child = jpaChildRepository.findById(childId);
        child.get().setName(updatedName);
        child.get().setDateOfBirth(LocalDate.parse(updatedDateOfBirth));
        jpaChildRepository.save(child.get());
        return new RedirectView("/children/list/");
    }
    @GetMapping("/personalizedSleepSchedule/{id}/{name}")
    public String personalizedSleepSchedule(Model model, @PathVariable("id") UUID childId, @PathVariable("name") String name){
        model.addAttribute("info", "Insert the last wake up hour of your child and you will find out the next hour for sleep");
        model.addAttribute("childId", childId);
        model.addAttribute("name", name);
        model.addAttribute("infoSleepSchedule", jpaInfoSleepScheduleRepository.findByTitle("Is important"));
        return ("/children/personalizedSleepScheduleForm");
    }
    @PostMapping("/personalizedSleepSchedule/{id}/{name}")
    public String personalizedSleepScheduleForm(Model model, @PathVariable("id") UUID childId, @PathVariable("name") String name, @RequestParam String wakeUpTime){
        Child child= jpaChildRepository.findById(childId).get();
        OptimalSleepSchedule schedule = jpaChildWithSleepScheduleRepository.findByMonth(child.getMonths());
        int nextSleepTime = schedule.getWakingPeriodMin() + convertWakeupTimeToInt(wakeUpTime);
        model.addAttribute("info", "It is recommended to wake up around 7 in the morning and go to bed in the evening between 7-8 pm");
        model.addAttribute("name", name);
        model.addAttribute("nextSleepTime", convertNextSleepTimeToString(nextSleepTime));
        model.addAttribute("infoSleepSchedule", jpaInfoSleepScheduleRepository.findByTitle("Is important"));

        return ("/children/personalizedSleepScheduleForm");
    }

    public int convertWakeupTimeToInt(String wakeUpTime){
         String[] hourMin = wakeUpTime.split(":");
         int hour = Integer.parseInt(hourMin[0]);
         int min = Integer.parseInt(hourMin[1]);
         int hoursInMin = hour * 60;
         return hoursInMin + min;
     }
    public String convertNextSleepTimeToString(int nextSleepTime){
        int minutes = nextSleepTime/60 ;
        int seconds = nextSleepTime % 60;
        return format("%02d:%02d", minutes, seconds);
    }


}






