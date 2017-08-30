package rest;

import abstractController.AbstractTicketController;
import model.Ticket;
import model.TicketInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by comp on 30.08.2017.
 */
@RestController
@RequestMapping(value = TicketREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketREST extends AbstractTicketController{
    public static final String REST_URL="rest/tickets";

    @GetMapping
    public List<Ticket> getAllTickets(){
        return super.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public List<TicketInfo> getAllTicketInfo(@PathVariable int ticketId){
        return super.getAllTicketInfo(ticketId);
    }
}
