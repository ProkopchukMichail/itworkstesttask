package dao;

import model.PeripheralDevice;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface PeripheralDeviceDAO {
    List<PeripheralDevice> getAll();
    PeripheralDevice get(int id);
    PeripheralDevice save(PeripheralDevice peripheralDevice);
    boolean delete(int id);
}
