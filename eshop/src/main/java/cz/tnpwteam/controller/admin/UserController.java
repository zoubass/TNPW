package cz.tnpwteam.controller.admin;

import cz.tnpwteam.dao.AuthoritiesRepository;
import cz.tnpwteam.dao.UserRepository;
import cz.tnpwteam.dto.UserDto;
import cz.tnpwteam.model.Authorities;
import cz.tnpwteam.model.AuthoritiesEnum;
import cz.tnpwteam.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Admin on 12.6.2016.
 */
@Controller
public class UserController {
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AuthoritiesRepository authorityRepo;
    @Autowired
    private AuthoritiesRepository authRepo;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute UserDto dto) {
        try {
            dto.getAuthorities().setUsername(dto.getUser().getUsername());
            userRepo.save(dto.getUser());
            authRepo.save(dto.getAuthorities());
            model.addAttribute("authorities", AuthoritiesEnum.values());
        } catch (Exception e) {
            model.addAttribute("isValidInput", false);
            model.addAttribute("error", "Nastal problém, zkontrolujte prosím zadané údaje.");
        }
        model.addAttribute("user", dto.getUser());
        return "admin/user";
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    public String remove(Model model, @ModelAttribute User u) {
        userRepo.save(u);
        model.addAttribute("isValidInput", true);
        model.addAttribute("user", new User());
        model.addAttribute("authorities", AuthoritiesEnum.values());
        return "admin/user";
    }

    @RequestMapping(value = "/showUsers", method = RequestMethod.POST)
    public String getUser(Model model, @ModelAttribute UserDto dto) {
        //TODO:
        List<Object> results = authorityRepo.filterByDto(dto.getUser().getUsername(), dto.getAuthorities().getAuthority());
        model.addAttribute("results", results);
        model.addAttribute("authorities", AuthoritiesEnum.values());
        model.addAttribute("userDto", new UserDto());
        return "admin/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        log.info("returning user");
        model.addAttribute("authorities", AuthoritiesEnum.values());
        model.addAttribute("user", new User());
        model.addAttribute("userDto", new UserDto());
        return "admin/user";
    }
}
