package service.impl;

import dao.InputDeviceDAO;
import model.InputDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.InputDeviceService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class InputDeviceServiceImpl implements InputDeviceService {
    @Autowired
    private InputDeviceDAO inputDeviceDAO;

    public List<InputDevice> getAll() {
        return Discount.inputDevicesWithDiscount(inputDeviceDAO.getAll());
    }

    @Transactional
    public InputDevice save(InputDevice inputDevice) {
        return inputDeviceDAO.save(inputDevice);
    }

    @Transactional
    public boolean delete(int id) {
        return inputDeviceDAO.delete(id);
    }
}
