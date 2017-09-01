package dao.jpa;

import dao.PeripheralDeviceDAO;
import model.PeripheralDevice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class PeripheralDeviceDAOImpl implements PeripheralDeviceDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PeripheralDevice> getAll() {
        return entityManager.createNamedQuery(PeripheralDevice.ALL, PeripheralDevice.class).getResultList();
    }

    @Override
    public PeripheralDevice get(int id) {
        return entityManager.find(PeripheralDevice.class,id);
    }

    public PeripheralDevice save(PeripheralDevice peripheralDevice) {
        if(peripheralDevice.isNew()){
            entityManager.persist(peripheralDevice);
            return peripheralDevice;
        } else return entityManager.merge(peripheralDevice);
    }


    public boolean delete(int id) {
        return entityManager.createNamedQuery(PeripheralDevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
