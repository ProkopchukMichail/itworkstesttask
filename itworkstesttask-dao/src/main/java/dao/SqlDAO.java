package dao;

import model.GoodType;

import java.util.List;

/**
 * Created by comp on 03.09.2017.
 */
public interface SqlDAO {

    List<GoodType> getGoodTypesWithMoreThan5Models();
}
