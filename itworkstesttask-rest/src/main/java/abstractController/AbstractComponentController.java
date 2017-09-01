package abstractController;

import dao.ComponentDAO;
import model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import service.ComponentService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public class AbstractComponentController {

    @Autowired
    private ComponentService componentService;

    public List<Component> getAll(){
        return componentService.getAll();
    }

    public boolean delete(int id){
        return componentService.delete(id);
    }

    public Component save(Component component){
        return componentService.save(component);
    }

}
