package cz.tnpwteam.controller;

import cz.tnpwteam.model.Cart;
import cz.tnpwteam.model.Product;
import cz.tnpwteam.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 12.6.2016.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    private Cart cart;

    //TODO: Musi byt mapping na lomitko kdyz uz mam controller na /cart
    @RequestMapping("/")
    public String loadProductPage(Model model) {
        System.out.println("you are in cart");
        return "cart";
    }

    @RequestMapping("/addProduct")
    public String addProductToCart(HttpServletRequest request, Model model, @RequestParam Product p) {
        cart = Util.getOrCreateCartForSession(request);
        cart.addProduct(p);
        return "cart";
    }

    @RequestMapping("/removeProduct")
    public String removeProductFromCart(HttpServletRequest request, Model model, @RequestParam Product p) {
        // zde by uz mel byt cart nenulovy
        cart.removeProduct(p);
        return "cart";
    }

    @RequestMapping("/recalculate")
    public String recalc(HttpServletRequest request, Model model, @RequestParam Product p) {
        // zde by uz mel byt cart nenulovy
        if (cart == null) System.out.println("Something's fucked up the cart is null. Correct it.");
        cart.calculateTotalValue();
        return "cart";
    }
}
