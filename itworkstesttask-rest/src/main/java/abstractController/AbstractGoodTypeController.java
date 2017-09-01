package abstractController;

import model.GoodType;
import org.springframework.beans.factory.annotation.Autowired;
import service.GoodTypeService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public class AbstractGoodTypeController {
    @Autowired
    private GoodTypeService goodTypeService;

    public List<GoodType> getAll(){
        return goodTypeService.getAll();
    }
}
