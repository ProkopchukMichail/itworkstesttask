package dao.jpa;

import dao.ComponentDAO;
import model.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class ComponentDAOImpl implements ComponentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Component> getAll() {
        return entityManager.createNamedQuery(Component.ALL, Component.class).getResultList();
    }

    @Transactional
    public Component save(Component component) {
        if (component.isNew()) {
            entityManager.persist(component);
            return component;
        } else return entityManager.merge(component);
    }

    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Component.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
