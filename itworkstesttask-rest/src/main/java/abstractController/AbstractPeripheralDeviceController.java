package abstractController;

import model.PeripheralDevice;
import org.springframework.beans.factory.annotation.Autowired;
import service.PeripheralDeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractPeripheralDeviceController {

    @Autowired
    private PeripheralDeviceService peripheralDeviceService;

    public List<PeripheralDevice> getAll(){
        return peripheralDeviceService.getAll();
    }

    public PeripheralDevice save(PeripheralDevice peripheralDevice){
        return peripheralDeviceService.save(peripheralDevice);
    }

    public boolean delete(int id){
         return peripheralDeviceService.delete(id);
    }
}
