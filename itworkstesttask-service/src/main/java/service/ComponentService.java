package service;

import model.Component;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public interface ComponentService {
    List<Component> getAll();
    boolean delete(int id);
    Component save(Component component);
}
