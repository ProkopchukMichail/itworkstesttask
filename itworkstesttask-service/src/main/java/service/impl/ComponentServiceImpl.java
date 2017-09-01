package service.impl;

import dao.ComponentDAO;
import model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ComponentService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@Service
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentDAO componentDAO;

    public List<Component> getAll() {
        return Discount.componentsWithDiscount(componentDAO.getAll());
    }

    @Transactional
    public boolean delete(int id) {
        return componentDAO.delete(id);
    }

    @Transactional
    public Component save(Component component) {
        return componentDAO.save(component);
    }
}
