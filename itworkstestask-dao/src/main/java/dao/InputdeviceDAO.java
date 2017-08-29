package dao;

import model.Inputdevice;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface InputdeviceDAO {
    List<Inputdevice> getAll();
    Inputdevice get(int id);
    Inputdevice save(Inputdevice inputdevice);
    boolean delete(int id);
}
