package abstractController;

import model.Peripheria;
import org.springframework.beans.factory.annotation.Autowired;
import service.PeripheriaService;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
public class AbstractPeripheriaController {

    @Autowired
    private PeripheriaService peripheriaService;

    public List<Peripheria> getAll(){
        return peripheriaService.getAll();
    }

    public Peripheria save(Peripheria peripheria){
        return peripheriaService.save(peripheria);
    }

    public boolean delete(int id){
         return peripheriaService.delete(id);
    }
}
