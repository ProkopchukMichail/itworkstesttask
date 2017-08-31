package dao;

import model.StorageDevice;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface StorageDeviceDAO {
    List<StorageDevice> getAll();
    StorageDevice get(int id);
    StorageDevice save(StorageDevice storageDevice);
    boolean delete(int id);
}
