package dao;

import model.Monitor;
import java.util.List;

/**
 * Created by comp on 24.08.2017.
 */
public interface MonitorDAO {
    List<Monitor> getAll();
    Monitor get(int id);
    Monitor save(Monitor monitor);
    boolean delete(int id);
}
