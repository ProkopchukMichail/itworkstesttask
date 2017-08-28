package service.impl;

import dao.PeripheralDAO;
import model.Peripheria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PeripheriaService;
import service.discount.Discount;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@Service
public class PeripheriaServiceImpl implements PeripheriaService {
    @Autowired
    private PeripheralDAO peripheralDAO;

    public List<Peripheria> getAll() {
        return Discount.peripheralsWithDiscount(peripheralDAO.getAll());
    }

    public Peripheria save(Peripheria peripheria) {
        return peripheralDAO.save(peripheria);
    }

    public boolean delete(int id) {
        return peripheralDAO.delete(id);
    }
}
