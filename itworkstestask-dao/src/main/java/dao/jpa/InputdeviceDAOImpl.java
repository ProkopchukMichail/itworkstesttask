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

    public List<Inputdevice> getAll() {
        return entityManager.createNamedQuery(Inputdevice.ALL, Inputdevice.class).getResultList();
    }

    @Transactional
    public Inputdevice save(Inputdevice inputdevice) {
        if (inputdevice.isNew()) {
            entityManager.persist(inputdevice);
            return inputdevice;
        } else return entityManager.merge(inputdevice);
    }

    @Transactional
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Inputdevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
