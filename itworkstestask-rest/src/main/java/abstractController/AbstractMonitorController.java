package abstractController;

import model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import service.MonitorService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractMonitorController {
    @Autowired
    private MonitorService monitorService;

    public List<Monitor> getAll(){
        return monitorService.getAll();
    }

    public Monitor save(Monitor monitor){
        return monitorService.save(monitor);
    }

    public boolean delete(int id){
        return monitorService.delete(id);
    }


}
