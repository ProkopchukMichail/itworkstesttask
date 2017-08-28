package service.impl;

import dao.StoragedeviceDAO;
import model.Storagedevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StoragedeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class StoragedeviceServiceImpl implements StoragedeviceService {
    @Autowired
    private StoragedeviceDAO storagedeviceDAO;

    public List<Storagedevice> getAll() {
        return storagedeviceDAO.getAll();
    }

    public Storagedevice save(Storagedevice storagedevice) {
        return storagedeviceDAO.save(storagedevice);
    }

    public boolean delete(int id) {
        return storagedeviceDAO.delete(id);
    }
}
