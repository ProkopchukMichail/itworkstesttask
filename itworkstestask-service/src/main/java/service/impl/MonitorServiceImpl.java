package service.impl;

import dao.MonitorDAO;
import model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.MonitorService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorDAO monitorDAO;

    public List<Monitor> getAll() {
        return Discount.monitorsWithDiscount(monitorDAO.getAll());
    }

    @Transactional
    public Monitor save(Monitor monitor) {
        return monitorDAO.save(monitor);
    }

    @Transactional
    public boolean delete(int id) {
        return monitorDAO.delete(id);
    }
}
