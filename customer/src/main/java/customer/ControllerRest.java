package customer;

import customer.models.Customers;
import customer.DB.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController //данный класс является REST контроллером.  логика обработки клиентских запросов
public class ControllerRest {

    @Autowired
    private DataBase dataBase;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customers> RestMethod2(Long id){
        Iterable<Customers> posts;
        if (id==null) { //Вывод всех записей
            posts = dataBase.findAllByOrderByIdAsc();
        }
        else { //Вывод конкретной записи
            Customers post = dataBase.findById(id).get();
            posts =  new ArrayList<>(Arrays.asList(post));
        }
        return posts;
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customers RestMethod(@RequestBody Customers post){
        post = dataBase.save(post);
        return post;
    }


    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customers RestMethod4(Long id){
        Customers post = dataBase.findById(id).get();
        dataBase.delete(post);
        return post;
    }

}
