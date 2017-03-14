package cz.tnpwteam.utils;

import cz.tnpwteam.dto.UserDto;
import cz.tnpwteam.model.Cart;
import cz.tnpwteam.model.Product;
import cz.tnpwteam.model.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 15.6.2016.
 */
public class Util {

    public static Cart getOrCreateCartForSession(HttpServletRequest request) {
        final Logger log = Logger.getLogger(Util.class);
        HttpSession session = request.getSession();
        Cart c = (Cart) session.getAttribute("cart");
        if (c == null) {
            log.debug("Nenasel se kosik, vytvarim tedy novy pro tuto session.");
            c = new Cart(new ArrayList<Product>());
            session.setAttribute("cart", c);
        }
        return c;
    }

    public static List<UserDto> parseResult(List<Object> results) {
        final List<UserDto> users = new ArrayList<UserDto>();
        for (Object o : results) {
            users.add(new UserDto());
        }
        return users;
    }

    public static List<String> getImageFileNames() {
        List<String> images = new ArrayList<>();
        //TODO: relative
        File folder = new File("C:\\Users\\Admin\\workspace\\TNPW2\\eshop\\src\\main\\webapp\\WEB-INF\\templates\\img");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String name = "img/" + listOfFiles[i].getName();
                images.add(name);
            }
        }
        return images;
    }
}
