package dao;

import model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
public interface TicketDAO {
    List<Ticket> getAll();
    Ticket save(Ticket ticket);
}
