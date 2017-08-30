package dao;

import model.Ticket;
import model.TicketInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TicketService;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by comp on 29.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-app.xml")
@ActiveProfiles("mysql")
public class TicketDAOTest {
    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private TicketService ticketService;

    @Test
    public void getAllTicket() {
        Assert.assertEquals(ticketDAO.getAll(), Arrays.asList());
    }

    /*@Test
    public void getAllTicketInfo() {
        Assert.assertEquals(ticketService.getAllTicketInfo(1),
                Arrays.asList(new TicketInfo(1, 1, 1, 1, "qwe", 123.0),
                        new TicketInfo(2,1,1,2,"qwer",234.05)));
    }

    @Test
    public void save() {
        Ticket ticket = new Ticket(4, LocalDateTime.now(), 100.0);
        ticketService.saveTicket(ticket);
        Assert.assertEquals(ticketDAO.getAll(), null);
    }
    @Test
    public void saveTicketInfo(){
        TicketInfo ticketInfo=new TicketInfo(5,1,1,1,"qwe",123.0);
        ticketService.saveTicketInfo(ticketInfo);
        Assert.assertEquals(ticketService.getAllTicketInfo(1),null);
    }*/
}
