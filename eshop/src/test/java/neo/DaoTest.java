package neo;

import neo.dao.UserDao;
import neo.dao.impl.UserDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Admin on 12.4.2016.
 */

@ContextConfiguration("classpath:META-INF/spring/application-context.xml")
public class DaoTest {

    @Autowired
    private UserDao dao;

    @Test
    public void testConnection() {
        Assert.assertNotNull(dao);
    }
}