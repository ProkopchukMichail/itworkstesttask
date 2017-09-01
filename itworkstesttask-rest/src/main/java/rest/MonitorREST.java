package rest;

import abstractController.AbstractMonitorController;
import model.Monitor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = MonitorREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MonitorREST extends AbstractMonitorController {
    public static final String REST_URL= GoodTypeREST.REST_URL+"/monitors";

    @GetMapping
    public List<Monitor> getAll(){
        return super.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id){
        return super.delete(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Monitor save(@RequestBody Monitor monitor){
        return super.save(monitor);
    }
}
