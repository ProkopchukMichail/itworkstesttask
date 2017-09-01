package rest;

import abstractController.AbstractTicketController;
import model.Ticket;
import model.TicketDTO;
import model.TicketInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping(value = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketDTO> pay(@RequestBody List<TicketDTO> ticketDTOList){
        return super.payAllGood(ticketDTOList);
    }
}
