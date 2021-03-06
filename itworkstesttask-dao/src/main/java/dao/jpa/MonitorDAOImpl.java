package dao.jpa;

import dao.MonitorDAO;
import model.Monitor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class MonitorDAOImpl implements MonitorDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Monitor> getAll() {
        return entityManager.createNamedQuery(Monitor.ALL,Monitor.class).getResultList();
    }

    @Override
    public Monitor save(Monitor monitor) {
        if(monitor.isNew()) {
            entityManager.persist(monitor);
            return monitor;
        } else return entityManager.merge(monitor);
    }

    @Override
    public Monitor get(int id) {
        return entityManager.find(Monitor.class,id);
    }

    @Override
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Monitor.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
