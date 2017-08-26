package rest;

import abstractController.AbstractComponentController;
import model.Component;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@RestController
@RequestMapping(value = ComponentREST.REST_URL,produces = MediaType.APPLICATION_JSON_VALUE)
public class ComponentREST extends AbstractComponentController {
    public static final String REST_URL=GoodstypeREST.REST_URL+"/components";

    @GetMapping
    public List<Component> getAll(){
        return super.getAll();
    }
}
