package com.blog.integration;

import com.blog.Application;
import com.blog.database.domain.User;
import com.blog.database.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Sergii Manko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void init() {
        userService.add("Ivan", "user", "123456");
    }

    @Test
    @DirtiesContext
    public final void findUserByIdTest_IsValid() {
        final User user = userService.findOne(1L);
        Assert.assertNotNull(user);
        Assert.assertEquals("Ivan", user.getName());
        Assert.assertEquals("user", user.getLogin());
        Assert.assertEquals("123456", user.getPassword());
    }

    @Test
    @DirtiesContext
    public final void findAllTest_IsValid() {
        final List<User> content = userService.findAll();
        Assert.assertTrue(content.size() > 0);
    }
}
