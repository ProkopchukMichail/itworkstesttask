package dao.jpa;

import dao.TicketDAO;
import model.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
@Repository
public class TicketDAOImpl implements TicketDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAll() {
        return entityManager.createNamedQuery(Ticket.ALL,Ticket.class).getResultList();
    }

    @Override
    public Ticket save(Ticket ticket) {
        if(ticket.isNew()){
            entityManager.persist(ticket);
            entityManager.flush();
            return ticket;
        }
        else {
            Ticket newTicket = entityManager.merge(ticket);
            return newTicket;
        }
    }

}













