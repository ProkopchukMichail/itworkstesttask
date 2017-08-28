package abstractController;

import model.Inputdevice;
import org.springframework.beans.factory.annotation.Autowired;
import service.InputdeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractInputdeviceController {
    @Autowired
    private InputdeviceService inputdeviceService;

    public List<Inputdevice> getAll(){
        return inputdeviceService.getAll();
    }

    public Inputdevice save(Inputdevice inputdevice){
        return inputdeviceService.save(inputdevice);
    }

    public boolean delete(int id){
        return inputdeviceService.delete(id);
    }
}
