package abstractController;

import model.InputDevice;
import org.springframework.beans.factory.annotation.Autowired;
import service.InputDeviceService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractInputDeviceController {
    @Autowired
    private InputDeviceService inputDeviceService;

    public List<InputDevice> getAll(){
        return inputDeviceService.getAll();
    }

    public InputDevice save(InputDevice inputDevice){
        return inputDeviceService.save(inputDevice);
    }

    public boolean delete(int id){
        return inputDeviceService.delete(id);
    }
}
