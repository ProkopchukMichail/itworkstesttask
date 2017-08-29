package dao;

import model.Storagedevice;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface StoragedeviceDAO {
    List<Storagedevice> getAll();
    Storagedevice get(int id);
    Storagedevice save(Storagedevice storagedevice);
    boolean delete(int id);
}
