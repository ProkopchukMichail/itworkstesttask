package dao.jpa;

import dao.GoodstypeDAO;
import model.Goodtype;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by comp on 24.08.2017.
 */
@Repository
public class GoodstypeDAOImpl implements GoodstypeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Goodtype> getAll() {
        return entityManager.createNamedQuery(Goodtype.ALL,Goodtype.class)
                .getResultList();
    }
}
