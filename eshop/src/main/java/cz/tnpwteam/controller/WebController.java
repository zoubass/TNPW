package cz.tnpwteam.controller;


import cz.tnpwteam.dao.UserRepository;
import cz.tnpwteam.model.Cart;
import cz.tnpwteam.model.User;
import cz.tnpwteam.utils.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller()
public class WebController {
    private final Logger log = Logger.getLogger(getClass());

    @RequestMapping("/{id}")
    public String doSomethingWithUser() {
//        TODO: zmenit stranku
        return "login";
    }

    @RequestMapping(value = {"/index", "/"})
    public String showHomePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Cart cart = Util.getOrCreateCartForSession(request);
        System.out.println("you are on home page");
        return "index";
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
