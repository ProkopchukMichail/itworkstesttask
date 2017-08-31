package dao.jpa;

import dao.StorageDeviceDAO;
import model.StorageDevice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class StorageDeviceDAOImpl implements StorageDeviceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StorageDevice> getAll() {
        return entityManager.createNamedQuery(StorageDevice.ALL, StorageDevice.class).getResultList();
    }

    @Override
    public StorageDevice get(int id) {
        return entityManager.find(StorageDevice.class,id);
    }

    public StorageDevice save(StorageDevice storageDevice) {
        if(storageDevice.isNew()){
            entityManager.persist(storageDevice);
            return storageDevice;
        } else return entityManager.merge(storageDevice);
    }
    public boolean delete(int id) {
        return entityManager.createNamedQuery(StorageDevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
