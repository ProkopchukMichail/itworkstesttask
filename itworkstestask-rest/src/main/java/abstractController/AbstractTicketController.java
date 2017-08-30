package abstractController;

import model.Ticket;
import model.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import service.TicketService;

import java.util.List;

/**
 * Created by comp on 30.08.2017.
 */
public class AbstractTicketController {
    @Autowired
    private TicketService ticketService;
    
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    
    public List<TicketInfo> getAllTicketInfo(int ticketId){
        return ticketService.getAllTicketInfo(ticketId);
    }
}
