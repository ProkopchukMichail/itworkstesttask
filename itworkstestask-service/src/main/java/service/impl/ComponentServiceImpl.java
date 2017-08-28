package service.impl;

import dao.ComponentDAO;
import model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import service.ComponentService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentDAO componentDAO;

    public List<Component> getAll() {
        return componentDAO.getAll();
    }

    public boolean delete(int id) {
        return componentDAO.delete(id);
    }

    public Component save(Component component) {
        return componentDAO.save(component);
    }
}
