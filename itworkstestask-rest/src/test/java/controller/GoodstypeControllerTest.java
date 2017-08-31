package controller;

import abstractController.AbstractGoodstypeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by comp on 25.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-app.xml")
@ActiveProfiles("mysql")
public class GoodstypeControllerTest {
    @Autowired
    private AbstractGoodstypeController controller;

    @Test
    public void getAll(){
        Assert.assertEquals(controller.getAll(), Arrays.asList());
    }

}
