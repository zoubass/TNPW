package cz.tnpwteam;

import com.google.common.collect.Lists;
import cz.tnpwteam.dao.UserRepository;
import cz.tnpwteam.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Admin on 12.4.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/application-context.xml")
public class DaoTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void testConnection() {
        Assert.assertNotNull(userRepo);
        Iterable<User> users = userRepo.findAll();
        List<User> userList = Lists.newArrayList(users);
        Assert.assertTrue(userList.size() > 0);
    }
}