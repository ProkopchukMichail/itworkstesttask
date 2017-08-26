package dao;


import model.BaseGood;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public interface GoodDAO {
    List<BaseGood> getAll(Class c);
}
