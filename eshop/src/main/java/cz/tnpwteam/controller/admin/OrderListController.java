package cz.tnpwteam.controller.admin;

import com.google.common.collect.Lists;
import cz.tnpwteam.dao.OrderRepository;
import cz.tnpwteam.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 20.6.2016.
 */
@Controller
public class OrderListController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductRepository prodRepo;

    @RequestMapping(value = {"/ordersList"})
    public String showOrderPage(Model model) {
        model.addAttribute("orders", orderRepo.findAll());
        return "ordersList";
    }

    @RequestMapping(value = "/getOrderProducts", method = RequestMethod.GET)
    public String showOrderProducts(Model model, @RequestParam Long id) {
        model.addAttribute("products", Lists.newArrayList(prodRepo.findByOrderId(id)));
        model.addAttribute("orders", orderRepo.findAll());
        return "ordersList";
    }

    @RequestMapping(value = {"/removeOrder"})
    public String deleteOrder(@RequestParam Long id, Model model) {
        orderRepo.delete(id);
        model.addAttribute("orders", orderRepo.findAll());
        return "ordersList";
    }

}
