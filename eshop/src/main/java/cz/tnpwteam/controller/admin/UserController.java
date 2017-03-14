package cz.tnpwteam.controller.admin;

import cz.tnpwteam.dao.AuthoritiesRepository;
import cz.tnpwteam.dao.UserRepository;
import cz.tnpwteam.dto.UserDto;
import cz.tnpwteam.model.Authorities;
import cz.tnpwteam.model.AuthoritiesEnum;
import cz.tnpwteam.model.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Admin on 19.6.2016.
 */
@Controller
public class UserController {
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AuthoritiesRepository authRepo;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(Model model, @Valid @ModelAttribute UserDto dto, BindingResult bindingResult) {
        String message = null;
        if (StringUtils.isEmpty(dto.getUser().getUsername()) || StringUtils.isEmpty(dto.getUser().getPassword())) {
            model.addAttribute("message", "Vyplňte všecha pole");
        }
        try {
            dto.getAuthorities().setUsername(dto.getUser().getUsername());
            userRepo.save(dto.getUser());
            authRepo.save(dto.getAuthorities());
            message = "Uživatel úspěšně vytvořen.";
            model.addAttribute("authorities", AuthoritiesEnum.values());
        } catch (Exception e) {
            message = "Vytvoření uživatele se nezdařilo.";
        }
        model.addAttribute("message", message);
        if (bindingResult.hasErrors()) {
            return "admin/user";
        }
        return "admin/user";
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    public String remove(Model model, @RequestParam String username) {
        Authorities a = authRepo.filterByUsername(username).get(0);
        authRepo.delete(a);
        User u = userRepo.filterByUsername(username).get(0);
        userRepo.delete(u);
        model.addAttribute("isValidInput", true);
        model.addAttribute("user", new User());
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("authorities", AuthoritiesEnum.values());
        return "admin/user";
    }

    @RequestMapping(value = "/showUsers", method = RequestMethod.POST)
    public String getUser(Model model, @ModelAttribute UserDto dto) {
        model.addAttribute("results", userRepo.filterByUsername(dto.getUser().getUsername()));
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
