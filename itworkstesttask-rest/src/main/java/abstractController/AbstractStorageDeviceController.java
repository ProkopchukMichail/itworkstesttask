package abstractController;

import model.StorageDevice;
import org.springframework.beans.factory.annotation.Autowired;
import service.StorageDeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractStorageDeviceController {
    @Autowired
    private StorageDeviceService storageDeviceService;

    public List<StorageDevice> getAll(){
        return storageDeviceService.getAll();
    }
    public boolean delete(int id){
        return storageDeviceService.delete(id);
    }
    public StorageDevice save(StorageDevice storageDevice){
        return storageDeviceService.save(storageDevice);
    }
}
