package cz.tnpwteam.controller;


import cz.tnpwteam.dao.UserRepository;
import cz.tnpwteam.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller()
public class WebController {
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/admin")
    public String showAdminPage(Model model) {
        System.out.println("I'm in admin.");
        Iterable<User> users = userRepo.findAll();
        return "admin";
    }

    @RequestMapping("/{id}")
    public String doSomethingWithUser() {
//        TODO: zmenit stranku
        return "admin";
    }

    @RequestMapping("/home")
    public String showHomePage(Model model) {
        System.out.println("you are on home page");
        return "home";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String errorMessage = null;
        if (throwable != null) {
            errorMessage = throwable.getMessage();
        }
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
