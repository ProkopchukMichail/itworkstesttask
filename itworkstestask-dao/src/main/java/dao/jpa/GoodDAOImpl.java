package dao.jpa;

import dao.GoodDAO;
import model.BaseGood;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public class GoodDAOImpl implements GoodDAO {
    public List<BaseGood> getAll(Class c) {
        try {
            /*String query = c.getDeclaredField("ALL").get(new Object()).toString();*/
            return null;
        } catch (Exception e){ return null;}/* catch (NoSuchFieldException e){return null;}*/
    }
}
