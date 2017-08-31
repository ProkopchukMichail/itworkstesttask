package dao.jpa;

import dao.InputdeviceDAO;
import model.Inputdevice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class InputdeviceDAOImpl implements InputdeviceDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Inputdevice> getAll() {
        return entityManager.createNamedQuery(Inputdevice.ALL, Inputdevice.class).getResultList();
    }

    @Override
    public Inputdevice get(int id) {
        return entityManager.find(Inputdevice.class,id);
    }

    @Override
    public Inputdevice save(Inputdevice inputdevice) {
        if (inputdevice.isNew()) {
            entityManager.persist(inputdevice);
            return inputdevice;
        } else return entityManager.merge(inputdevice);
    }

    @Override
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Inputdevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
