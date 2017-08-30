package service.impl;

import dao.*;
import model.Inputdevice;
import model.Ticket;
import model.TicketDTO;
import model.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TicketService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by comp on 29.08.2017.
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private TicketInfoDAO ticketInfoDAO;
    @Autowired
    private InputdeviceDAO inputdeviceDAO;
    @Autowired
    private ComponentDAO componentDAO;
    @Autowired
    private MonitorDAO monitorDAO;
    @Autowired
    private PeripheralDAO peripheralDAO;
    @Autowired
    private StoragedeviceDAO storagedeviceDAO;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAll();
    }

    @Override
    public List<TicketInfo> getAllTicketInfo(int ticketId) {
        return ticketInfoDAO.getAll(ticketId);
    }

  /*  @Override
    @Transactional
    public void save(List<TicketDTO> ticketDTOList) {
        List<TicketInfo> ticketInfos=new ArrayList<TicketInfo>();

        Double summ=0.0;
        for(TicketDTO t:ticketDTOList){
            summ+=t.getCost();
        }
        for(TicketDTO t:ticketDTOList){
            Ticket ticket=ticketDAO.save(new Ticket(0, LocalDateTime.now(),summ));
            TicketInfo ticketInfo=new TicketInfo(0,ticket.getId(),t.getTypeId(),t.getGoodId(),t.getName(),t.getCost());
            ticketInfos.add(ticketInfo);
        }

        for(TicketInfo t:ticketInfos){
            int typeId=t.getTypeId();
            if(typeId==1){
                Inputdevice inputdevice=inputdeviceDAO.get(t.getId());
                if(inputdevice.getQuantity()>=1){
                    inputdevice.setQuantity(inputdevice.getQuantity()-1);
                    inputdeviceDAO.save(inputdevice);
                    ticketInfoDAO.save(t);
                }
            }
            if(typeId==2){

            }
            if(typeId==3){

            }
            if(typeId==4){

            }
            if(typeId==5){

            }
        }
    }


    @Override
    @Transactional
    public Ticket saveTicket(Ticket ticket) {
        return ticketDAO.save(ticket);
    }

    @Override
    @Transactional
    public void saveTicketInfo(TicketInfo ticketInfo){
        ticketInfoDAO.save(ticketInfo);
    }*/
}
