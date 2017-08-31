package rest;

import abstractController.AbstractInputDeviceController;
import model.InputDevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = InputDeviceREST.REST_API,produces = MediaType.APPLICATION_JSON_VALUE)
public class InputDeviceREST extends AbstractInputDeviceController {
    public static final String REST_API= GoodTypeREST.REST_URL+"/inputdevices";

    @GetMapping
    public List<InputDevice> getAll(){
        return super.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id){
        return super.delete(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InputDevice save(@RequestBody InputDevice inputDevice){
        return super.save(inputDevice);
    }
}
