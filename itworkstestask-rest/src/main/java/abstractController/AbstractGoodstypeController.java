package abstractController;

import model.Goodtype;
import org.springframework.beans.factory.annotation.Autowired;
import service.GoodstypeService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
public class AbstractGoodstypeController {
    @Autowired
    private GoodstypeService goodstypeService;

    public List<Goodtype> getAll(){
        return goodstypeService.getAll();
    }
}
