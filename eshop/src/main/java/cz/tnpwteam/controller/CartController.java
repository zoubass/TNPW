package cz.tnpwteam.controller;

import cz.tnpwteam.dao.ProductRepository;
import cz.tnpwteam.model.Cart;
import cz.tnpwteam.model.Product;
import cz.tnpwteam.utils.Util;
import org.apache.log4j.Logger;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 19.6.2016.
 */
@Controller
public class CartController {
    private Cart cart;
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String loadCart(HttpServletRequest request, Model model) {
        cart = Util.getOrCreateCartForSession(request);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping("/addProduct")
    public String addProductToCart(HttpServletRequest request, Model model, @ModelAttribute Product p) {
        cart = Util.getOrCreateCartForSession(request);
        cart.addProduct(p);
        model.addAttribute("cart", cart);
        return loadCart(request,model);
    }

    @RequestMapping("/removeProduct")
    public String removeProductFromCart(HttpServletRequest request, Model model, @RequestParam Long id) {
        // zde by uz mel byt cart nenulovy
        cart.removeProduct(productRepo.findOne(id));
        model.addAttribute("cart", cart);
        return "cart";
    }
}
