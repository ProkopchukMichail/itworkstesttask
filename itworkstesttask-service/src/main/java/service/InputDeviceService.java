package service;

import model.InputDevice;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface InputDeviceService {
    List<InputDevice> getAll();
    InputDevice save(InputDevice inputDevice);
    boolean delete(int id);
}
