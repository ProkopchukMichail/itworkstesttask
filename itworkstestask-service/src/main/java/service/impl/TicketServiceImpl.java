package service.impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TicketService;
import service.discount.Discount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by comp on 29.08.2017.
 */
@Service
public class TicketServiceImpl implements TicketService {
    private final Logger logger = Logger.getLogger("ticketLogger");

    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private TicketInfoDAO ticketInfoDAO;
    @Autowired
    private InputDeviceDAO inputDeviceDAO;
    @Autowired
    private ComponentDAO componentDAO;
    @Autowired
    private MonitorDAO monitorDAO;
    @Autowired
    private PeripheralDeviceDAO peripheralDeviceDAO;
    @Autowired
    private StorageDeviceDAO storageDeviceDAO;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAll();
    }

    @Override
    public List<TicketInfo> getAllTicketInfo(int ticketId) {
        return ticketInfoDAO.getAll(ticketId);
    }

    @Override
    @Transactional
    public List<TicketDTO> pay(List<TicketDTO> ticketDTOList) {
        LocalDateTime dateTime = LocalDateTime.now();
        double totalCost=0.0;
        List<ProxyTicket> proxyTickets=getProxyTickets(ticketDTOList);
        for(ProxyTicket p:proxyTickets) totalCost+=p.cost*p.amount;
        if(proxyTickets.size()==0) return null;
        Ticket ticket=ticketDAO.save(new Ticket(null,dateTime,totalCost));
        for(ProxyTicket p:proxyTickets){
            ticketInfoDAO.save(new TicketInfo(null,ticket.getId(),p.typeId,p.goodId,p.name,p.amount,p.cost));
            reduceGoodAmount(p.typeId,p.goodId,p.amount);
        }
        return ticketDTOList;
    }


    private List<ProxyTicket> getProxyTickets(List<TicketDTO> ticketDTOList) {
        List<ProxyTicket> proxyTickets = new ArrayList<ProxyTicket>();
        for (TicketDTO t : ticketDTOList) {
            int typeId = t.getTypeId();
            int goodId = t.getId();
            int amount = t.getAmount();
            String name = "";
            double cost = 0.0;
            if (typeId == 1) {
                InputDevice inputDevice = inputDeviceDAO.get(goodId);
                if (inputDevice.getQuantity() < amount) return Collections.emptyList();
                cost = Discount.inputDeviceWithDiscount(inputDevice).getCost();
                name = inputDevice.getName();
                proxyTickets.add(new ProxyTicket(typeId, goodId, amount, name, cost));
            }
            if (typeId == 2) {
                Component component=componentDAO.get(goodId);
                if (component.getQuantity() < amount) return Collections.emptyList();
                cost = Discount.componentWithDiscount(component).getCost();
                name = component.getName();
                proxyTickets.add(new ProxyTicket(typeId, goodId, amount, name, cost));
            }
            if (typeId == 3) {
                Monitor monitor=monitorDAO.get(goodId);
                if (monitor.getQuantity() < amount) return Collections.emptyList();
                cost = Discount.monitorWithDiscount(monitor).getCost();
                name = monitor.getName();
                proxyTickets.add(new ProxyTicket(typeId, goodId, amount, name, cost));
            }
            if (typeId == 4) {
                StorageDevice storageDevice = storageDeviceDAO.get(goodId);
                if (storageDevice.getQuantity() < amount) return Collections.emptyList();
                cost = Discount.storageDeviceWithDiscount(storageDevice).getCost();
                name = storageDevice.getName();
                proxyTickets.add(new ProxyTicket(typeId, goodId, amount, name, cost));
            }
            if (typeId == 5) {
                PeripheralDevice peripheralDevice = peripheralDeviceDAO.get(goodId);
                if (peripheralDevice.getQuantity() < amount) return Collections.emptyList();
                cost = Discount.peripheralDeviceWithDiscount(peripheralDevice).getCost();
                name = peripheralDevice.getName();
                proxyTickets.add(new ProxyTicket(typeId, goodId, amount, name, cost));
            }
        }
        return proxyTickets;
    }

    private void reduceGoodAmount(int typeId, int id, int amount) {
        if (typeId == 1) {
            InputDevice inputDevice = inputDeviceDAO.get(id);
            inputDevice.setQuantity(inputDevice.getQuantity() - amount);
            inputDeviceDAO.save(inputDevice);
        }
        if (typeId == 2) {
            Component component=componentDAO.get(id);
            component.setQuantity(component.getQuantity() - amount);
            componentDAO.save(component);
        }
        if (typeId == 3) {
            Monitor monitor=monitorDAO.get(id);
            monitor.setQuantity(monitor.getQuantity() - amount);
            monitorDAO.save(monitor);
        }
        if (typeId == 4) {
            StorageDevice storageDevice = storageDeviceDAO.get(id);
            storageDevice.setQuantity(storageDevice.getQuantity() - amount);
            storageDeviceDAO.save(storageDevice);
        }
        if (typeId == 5) {
            PeripheralDevice peripheralDevice = peripheralDeviceDAO.get(id);
            peripheralDevice.setQuantity(peripheralDevice.getQuantity() - amount);
            peripheralDeviceDAO.save(peripheralDevice);
        }
    }

    class ProxyTicket {
        int typeId, goodId, amount;
        String name;
        double cost;

        public ProxyTicket(int typeId, int goodId, int amount, String name, double cost) {
            this.typeId = typeId;
            this.goodId = goodId;
            this.amount = amount;
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "ProxyTicket{" +
                    "typeId=" + typeId +
                    ", goodId=" + goodId +
                    ", amount=" + amount +
                    ", name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
}

