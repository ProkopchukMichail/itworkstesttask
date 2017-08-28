package abstractController;

import model.Storagedevice;
import org.springframework.beans.factory.annotation.Autowired;
import service.StoragedeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractStoragedeviceController {
    @Autowired
    private StoragedeviceService storagedeviceService;

    public List<Storagedevice> getAll(){
        return storagedeviceService.getAll();
    }
    public boolean delete(int id){
        return storagedeviceService.delete(id);
    }
    public Storagedevice save(Storagedevice storagedevice){
        return storagedeviceService.save(storagedevice);
    }
}
