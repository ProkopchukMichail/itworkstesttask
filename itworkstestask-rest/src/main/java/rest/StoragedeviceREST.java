package rest;

import abstractController.AbstractStoragedeviceController;
import model.Storagedevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = StoragedeviceREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class StoragedeviceREST extends AbstractStoragedeviceController {
    public static final String REST_URL = GoodstypeREST.REST_URL + "/storagedevices";

    @GetMapping
    public List<Storagedevice> getAll() {
        return super.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Storagedevice save(@RequestBody Storagedevice storagedevice) {
        return super.save(storagedevice);
    }

}
