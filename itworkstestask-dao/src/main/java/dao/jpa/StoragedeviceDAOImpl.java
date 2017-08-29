package dao.jpa;

import dao.StoragedeviceDAO;
import model.Storagedevice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class StoragedeviceDAOImpl implements StoragedeviceDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Storagedevice> getAll() {
        return entityManager.createNamedQuery(Storagedevice.ALL,Storagedevice.class).getResultList();
    }

    @Override
    public Storagedevice get(int id) {
        return entityManager.find(Storagedevice.class,id);
    }

    public Storagedevice save(Storagedevice storagedevice) {
        if(storagedevice.isNew()){
            entityManager.persist(storagedevice);
            return storagedevice;
        } else return entityManager.merge(storagedevice);
    }
    public boolean delete(int id) {
        return entityManager.createNamedQuery(Storagedevice.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
