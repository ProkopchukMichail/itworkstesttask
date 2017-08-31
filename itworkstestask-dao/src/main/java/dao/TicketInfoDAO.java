package dao;

import model.TicketInfo;

import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
public interface TicketInfoDAO {
    List<TicketInfo> getAll(int ticketId);
    TicketInfo save(TicketInfo ticketInfo);
}
