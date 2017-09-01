package abstractController;

import model.Ticket;
import model.TicketDTO;
import model.TicketInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import service.TicketService;

import java.util.List;

/**
 * Created by comp on 30.08.2017.
 */
public class AbstractTicketController {
    private final Logger logger=Logger.getLogger(getClass());
    @Autowired
    private TicketService ticketService;
    
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    
    public List<TicketInfo> getAllTicketInfo(int ticketId){
        return ticketService.getAllTicketInfo(ticketId);
    }

    public List<TicketDTO> payAllGood(List<TicketDTO> ticketDTOList) {
        logger.warn(">> paying: "+ticketDTOList);
        return ticketService.pay(ticketDTOList);
    }
}
