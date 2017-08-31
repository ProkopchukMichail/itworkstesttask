package dao.jpa;

import dao.TicketInfoDAO;
import model.TicketInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
@Repository
public class TicketInfoDAOmpl implements TicketInfoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketInfo> getAll(int ticketId) {
        return entityManager.createNamedQuery(TicketInfo.ALL,TicketInfo.class).setParameter("ticketId",ticketId).getResultList();
    }

    @Override
    public TicketInfo save(TicketInfo ticketInfo) {
        if(ticketInfo.isNew()){
            entityManager.persist(ticketInfo);
            return ticketInfo;
        }
        else return entityManager.merge(ticketInfo);
    }
}
