package service;

import model.Inputdevice;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface InputdeviceService {
    List<Inputdevice> getAll();
    Inputdevice save(Inputdevice inputdevice);
    boolean delete(int id);
}
