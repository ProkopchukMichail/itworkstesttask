package rest;

import abstractController.AbstractInputdeviceController;
import model.Inputdevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = InputdeviceREST.REST_API,produces = MediaType.APPLICATION_JSON_VALUE)
public class InputdeviceREST extends AbstractInputdeviceController {
    public static final String REST_API=GoodstypeREST.REST_URL+"/inputdevices";

    @GetMapping
    public List<Inputdevice> getAll(){
        return super.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id){
        return super.delete(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Inputdevice save(@RequestBody Inputdevice inputdevice){
        return super.save(inputdevice);
    }
}
