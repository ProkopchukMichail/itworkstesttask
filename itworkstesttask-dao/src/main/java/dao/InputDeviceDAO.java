package dao;

import model.InputDevice;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface InputDeviceDAO {
    List<InputDevice> getAll();
    InputDevice get(int id);
    InputDevice save(InputDevice inputDevice);
    boolean delete(int id);
}
