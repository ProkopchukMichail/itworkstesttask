package service;

import model.Peripheria;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface PeripheriaService {
    List<Peripheria> getAll();
    Peripheria save(Peripheria peripheria);
    boolean delete(int id);
}
