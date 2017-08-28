package dao;

import model.Component;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface ComponentDAO {
    List<Component> getAll();
    Component save(Component component);
    boolean delete(int id);
}
