package service;

import model.Storagedevice;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface StoragedeviceService {
    List<Storagedevice> getAll();
    Storagedevice save(Storagedevice storagedevice);
    boolean delete(int id);
}
