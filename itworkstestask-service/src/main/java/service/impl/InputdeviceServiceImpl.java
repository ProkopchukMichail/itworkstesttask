package service.impl;

import dao.InputdeviceDAO;
import model.Inputdevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.InputdeviceService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class InputdeviceServiceImpl implements InputdeviceService {
    @Autowired
    private InputdeviceDAO inputdeviceDAO;

    public List<Inputdevice> getAll() {
        return Discount.inputdevicesWithDiscount(inputdeviceDAO.getAll());
    }

    @Transactional
    public Inputdevice save(Inputdevice inputdevice) {
        return inputdeviceDAO.save(inputdevice);
    }

    @Transactional
    public boolean delete(int id) {
        return inputdeviceDAO.delete(id);
    }
}
