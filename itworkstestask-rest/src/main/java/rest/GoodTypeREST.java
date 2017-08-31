package rest;

import abstractController.AbstractGoodTypeController;
import model.GoodType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@RestController
@RequestMapping(value = GoodTypeREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodTypeREST extends AbstractGoodTypeController {
    public static final String REST_URL="rest/goodstype";

    @GetMapping
    public List<GoodType> getAll(){
        return super.getAll();
    }
}
