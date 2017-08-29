package dao.jpa;

import dao.PeripheralDAO;
import model.Peripheria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class PeripheralDAOImpl implements PeripheralDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Peripheria> getAll() {
        return entityManager.createNamedQuery(Peripheria.ALL,Peripheria.class).getResultList();
    }

    @Override
    public Peripheria get(int id) {
        return entityManager.find(Peripheria.class,id);
    }

    public Peripheria save(Peripheria peripheria) {
        if(peripheria.isNew()){
            entityManager.persist(peripheria);
            return peripheria;
        } else return entityManager.merge(peripheria);
    }


    public boolean delete(int id) {
        return entityManager.createNamedQuery(Peripheria.DELETE).setParameter("id",id).executeUpdate()!=0;
    }
}
