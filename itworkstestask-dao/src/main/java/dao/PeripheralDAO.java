package dao;

import model.Peripheria;

import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface PeripheralDAO {
    List<Peripheria> getAll();
    Peripheria get(int id);
    Peripheria save(Peripheria peripheria);
    boolean delete(int id);
}
