package service.impl;

import dao.GoodTypeDAO;
import model.GoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GoodTypeService;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@Service
public class GoodTypeServiceImpl implements GoodTypeService {
    @Autowired
    private GoodTypeDAO goodTypeDAO;

    public List<GoodType> getAll() {
        return goodTypeDAO.getAll();
    }
}
