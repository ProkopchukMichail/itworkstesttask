package service;

import model.Monitor;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public interface MonitorService {
    List<Monitor> getAll();
    Monitor save(Monitor monitor);
    boolean delete(int id);
}
