package dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static testdata.ComponentTestData.*;


import java.util.Arrays;

/**
 * Created by comp on 24.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-app.xml")
@ActiveProfiles("mysql")
public class ComponentDAOTest {

    @Autowired
    ComponentDAO componentDAO;

    @Test
    public void getAll(){
        Assert.assertEquals(componentDAO.getAll(), Arrays.asList(COMPONENT1,COMPONENT2,COMPONENT3));
    }

    @Test
    public void get(){
        Assert.assertEquals(componentDAO.get(1),COMPONENT1);
    }

    @Test
    public void update(){
        componentDAO.save(COMPONENT_UPDATE);
        Assert.assertEquals(componentDAO.getAll(),Arrays.asList(COMPONENT1,COMPONENT2,COMPONENT_UPDATE));
    }

    @Test
    public void delete(){
        componentDAO.delete(3);
        Assert.assertEquals(componentDAO.getAll(),Arrays.asList(COMPONENT1,COMPONENT2));
    }

    @Test
    public void create(){
        componentDAO.save(COMPONENT3);
        Assert.assertEquals(componentDAO.getAll(),Arrays.asList(COMPONENT1,COMPONENT2,COMPONENT3));
    }
}
