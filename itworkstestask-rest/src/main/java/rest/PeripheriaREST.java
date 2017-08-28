package rest;

import abstractController.AbstractPeripheriaController;
import model.Peripheria;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = PeripheriaREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class PeripheriaREST extends AbstractPeripheriaController {
    public static final String REST_URL=GoodstypeREST.REST_URL+"/peripherals";

    @GetMapping
    public List<Peripheria> getAll(){
        return super.getAll();
    }
    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id){
        return super.delete(id);
    }
    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Peripheria save(@RequestBody Peripheria peripheria){
        return super.save(peripheria);
    }

}
