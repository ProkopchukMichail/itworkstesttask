package service.impl;

import dao.PeripheralDeviceDAO;
import model.PeripheralDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.PeripheralDeviceService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class PeripheralDeviceServiceImpl implements PeripheralDeviceService {
    @Autowired
    private PeripheralDeviceDAO peripheralDeviceDAO;

    public List<PeripheralDevice> getAll() {
        return Discount.peripheralDevicesWithDiscount(peripheralDeviceDAO.getAll());
    }

    @Transactional
    public PeripheralDevice save(PeripheralDevice peripheralDevice) {
        return peripheralDeviceDAO.save(peripheralDevice);
    }

    @Transactional
    public boolean delete(int id) {
        return peripheralDeviceDAO.delete(id);
    }
}
