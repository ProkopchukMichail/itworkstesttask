package service.impl;

import dao.GoodstypeDAO;
import model.Goodtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GoodstypeService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@Service
public class GoodstypeServiceImpl implements GoodstypeService {
    @Autowired
    private GoodstypeDAO goodstypeDAO;

    public List<Goodtype> getAll() {
        return goodstypeDAO.getAll();
    }
}
