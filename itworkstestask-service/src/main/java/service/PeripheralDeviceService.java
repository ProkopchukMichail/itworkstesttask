package service;

import model.PeripheralDevice;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface PeripheralDeviceService {
    List<PeripheralDevice> getAll();
    PeripheralDevice save(PeripheralDevice peripheralDevice);
    boolean delete(int id);
}
