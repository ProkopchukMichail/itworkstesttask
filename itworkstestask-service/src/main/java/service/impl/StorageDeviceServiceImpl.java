package service.impl;


import dao.StorageDeviceDAO;
import model.StorageDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.StorageDeviceService;
import service.discount.Discount;


import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class StorageDeviceServiceImpl implements StorageDeviceService {
    @Autowired
    private StorageDeviceDAO storageDeviceDAO;

    public List<StorageDevice> getAll() {
        return Discount.storageDevicesWithDiscount(storageDeviceDAO.getAll());
    }

    @Transactional
    public StorageDevice save(StorageDevice storageDevice) {
        return storageDeviceDAO.save(storageDevice);
    }

    @Transactional
    public boolean delete(int id) {
        return storageDeviceDAO.delete(id);
    }
}
