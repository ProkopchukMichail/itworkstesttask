package rest;

import abstractController.AbstractStorageDeviceController;
import model.StorageDevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by comp on 28.08.2017.
 */
@RestController
@RequestMapping(value = StorageDeviceREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class StorageDeviceREST extends AbstractStorageDeviceController {
    public static final String REST_URL = GoodTypeREST.REST_URL + "/storagedevices";

    @GetMapping
    public List<StorageDevice> getAll() {
        return super.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public boolean delete(@PathVariable int id) {
        return super.delete(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StorageDevice save(@RequestBody StorageDevice storageDevice) {
        return super.save(storageDevice);
    }

}
