import dao.ComponentDAO;
import dao.SqlDAO;
import model.GoodType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by comp on 03.09.2017.
 */
@ContextConfiguration("classpath:spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SqlDAOtest {

    @Autowired
    private SqlDAO sqlDAO;

    @Autowired
    private ComponentDAO cDAO;

    @Test
    public void getGoodTypesWithMoreThan5ModelsTest(){
        System.out.println("sdfasdfasdf");
        System.out.println(cDAO.getAll());
        //Assert.assertEquals(sqlDAO.getGoodTypesWithMoreThan5Models(), Arrays.asList(new GoodType(1,"Input device"), new GoodType(2, "Component")));
    }

    @Test
    public void getGoodsWithSoldAmountTest(){
        Assert.assertEquals(sqlDAO.getGoodsWithSoldAmount(),Arrays.asList("qwe"));
    }
}
