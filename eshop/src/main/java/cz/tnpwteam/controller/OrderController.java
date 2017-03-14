package cz.tnpwteam.controller;

import cz.tnpwteam.dao.OrderRepository;
import cz.tnpwteam.dao.ProductRepository;
import cz.tnpwteam.model.Cart;
import cz.tnpwteam.model.Order;
import cz.tnpwteam.model.Product;
import cz.tnpwteam.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Admin on 19.6.2016.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private ProductRepository prodRepo;

    @RequestMapping("/order")
    public String loginError(Model model, HttpServletRequest request) {
        Cart c = Util.getOrCreateCartForSession(request);
        Order o = new Order(c.calculateTotalValue(), c.getProducts().size());
        model.addAttribute("order", o);
        return "order";
    }

    @RequestMapping("/createOrder")
    public String loginError(Model model, HttpServletRequest request, @Valid @ModelAttribute Order o, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) return "order";
            o = orderRepo.save(o);
            Cart c = Util.getOrCreateCartForSession(request);
            assignProductsToOrder(c.getProducts(), o.getId());
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("message", "Nastal problém, zkontrolujte prosím zadané údaje.");
        }
        return "order";
    }

    private void assignProductsToOrder(List<Product> products, Long orderId) {
        for (Product p : products) {
            Product newProduct = prodRepo.findOne(p.getId());
            newProduct.setOrderId(orderId);
            prodRepo.save(newProduct);
        }
    }
}
