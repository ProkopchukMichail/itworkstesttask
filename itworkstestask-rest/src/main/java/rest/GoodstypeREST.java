package rest;

import abstractController.AbstractGoodstypeController;
import model.Goodtype;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by comp on 25.08.2017.
 */
@RestController
@RequestMapping(value = GoodstypeREST.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodstypeREST extends AbstractGoodstypeController{
    public static final String REST_URL="rest/goodstype";

    @GetMapping
    public List<Goodtype> getAll(){
        return super.getAll();
    }
}
