package dao.jpa;

import dao.InputDeviceDAO;
import model.InputDevice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class InputDeviceDAOImpl implements InputDeviceDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InputDevice> getAll() {
        return entityManager.createNamedQuery(InputDevice.ALL, InputDevice.class).getResultList();
    }

    @Override
    public InputDevice get(int id) {
        return entityManager.find(InputDevice.class,id);
    }

    @Override
    public InputDevice save(InputDevice inputDevice) {
        if (inputDevice.isNew()) {
            entityManager.persist(inputDevice);
            return inputDevice;
        } else return entityManager.merge(inputDevice);
    }

    @Override
    public boolean delete(int id) {
        return entityManager.createNamedQuery(InputDevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
