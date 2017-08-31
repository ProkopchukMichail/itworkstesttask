package dao.jpa;

import dao.ComponentDAO;
import model.Component;
import org.springframework.stereotype.Repository;
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

    public Component get(int id){
        return entityManager.find(Component.class,id);
    }

    public Component save(Component component) {
        if (component.isNew()) {
            entityManager.persist(component);
            return component;
        } else return entityManager.merge(component);
    }


    public boolean delete(int id) {
        return entityManager.createNamedQuery(Component.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
