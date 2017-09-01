package service;

import model.StorageDevice;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface StorageDeviceService {
    List<StorageDevice> getAll();
    StorageDevice save(StorageDevice storageDevice);
    boolean delete(int id);
}
