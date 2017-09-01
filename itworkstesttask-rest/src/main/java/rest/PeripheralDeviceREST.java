package rest;

import abstractController.AbstractPeripheralDeviceController;
import model.PeripheralDevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = PeripheralDeviceREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class PeripheralDeviceREST extends AbstractPeripheralDeviceController {
    public static final String REST_URL= GoodTypeREST.REST_URL+"/peripherals";

    @GetMapping
    public List<PeripheralDevice> getAll(){
        return super.getAll();
    }
    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id){
        return super.delete(id);
    }
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PeripheralDevice save(@RequestBody PeripheralDevice peripheralDevice){
        return super.save(peripheralDevice);
    }

}
