package cz.tnpwteam.controller.admin;

import cz.tnpwteam.dao.ProductRepository;
import cz.tnpwteam.model.Product;
import cz.tnpwteam.utils.Util;
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
import java.util.List;

/**
 * Created by Admin on 15.6.2016.
 */
@Controller
public class ProductController {
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private ProductRepository productRepo;

    @RequestMapping(value = "/addProductsDb", method = RequestMethod.POST)
    public String addP(Model model, @ModelAttribute Product p) {
        productRepo.save(p);
        setModelAttributes(model, true);
        model.addAttribute("succes", "Product uložen!");
        return "redirect:/product";
    }

    @RequestMapping(value = "/removeProductdb", method = RequestMethod.GET)
    public String removeP(Model model, @RequestParam("id") Long id) {
        productRepo.delete(id);
        setModelAttributes(model, true);
        model.addAttribute("images", Util.getImageFileNames());
        return "admin/product";
    }

    @RequestMapping(value = "/updateProducts", method = RequestMethod.GET)
    public String showEditForm(Model model, @RequestParam("id") Long id) {
        Product p = productRepo.findOne(id);
        model.addAttribute("product", p);
        model.addAttribute("images", Util.getImageFileNames());
        return "admin/product";
    }

    @RequestMapping(value = "searchProducts", method = RequestMethod.POST)
    public String search(Model model, @ModelAttribute @Valid Product p, BindingResult bindingResult) {
        List<Product> products = productRepo.findSpecificProducts(p.getType(),/*, p.getPrice(),*/ p.getCategory());
        model.addAttribute("isValidInput", !bindingResult.hasErrors());
        model.addAttribute("products", products);
        model.addAttribute("images", Util.getImageFileNames());
        return "admin/product";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String showForm(Model model) {
        log.info("Showing product form");
        model.addAttribute("product", new Product());
        model.addAttribute("images", Util.getImageFileNames());
        return "admin/product";
    }

    private void setModelAttributes(Model model, boolean isValid) {
        model.addAttribute("isValidInput", isValid);
        model.addAttribute("product", new Product());
        model.addAttribute("images", Util.getImageFileNames());
    }
}
