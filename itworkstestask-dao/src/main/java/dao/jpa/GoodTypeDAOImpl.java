package dao.jpa;

import dao.GoodTypeDAO;
import model.GoodType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class GoodTypeDAOImpl implements GoodTypeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<GoodType> getAll() {
        return entityManager.createNamedQuery(GoodType.ALL, GoodType.class)
                .getResultList();
    }
}
