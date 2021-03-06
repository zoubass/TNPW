package cz.tnpwteam.controller;


import cz.tnpwteam.dao.OrderRepository;
import cz.tnpwteam.model.Cart;
import cz.tnpwteam.utils.Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller()
public class WebController {
    private final Logger log = Logger.getLogger(getClass());

    @RequestMapping(value = {"/index", "/"})
    public String showHomePage(HttpServletRequest request, Model model) {
        Cart cart = Util.getOrCreateCartForSession(request);
        log.info("you are on home page");
        return "index";
    }

    @RequestMapping(value = {"/products"})
    public String showProductPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Cart cart = Util.getOrCreateCartForSession(request);
        log.debug("you are on product page");
        return "offer";
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

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
