package service;

import model.Ticket;
import model.TicketDTO;
import model.TicketInfo;

import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
public interface TicketService {
    List<Ticket> getAllTickets();
    List<TicketInfo> getAllTicketInfo(int ticketId);
    void save(List<TicketDTO> ticketDTOList);
    Ticket saveTicket(Ticket ticket);
    void saveTicketInfo(TicketInfo ticketInfo);
}
