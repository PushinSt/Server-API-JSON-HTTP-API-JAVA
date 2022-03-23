package account;

import account.models.Accounts;
import account.DB.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController //данный класс является REST контроллером.  логика обработки клиентских запросов
public class ControllerRest {

    @Autowired
    private DataBase dataBase;

    @RequestMapping(value = "/account", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Accounts AddMethod(@RequestBody Accounts post){

        if ((post.getId()==null)&&(post.getNumber()==null)) { //Если данных нет - то добавление нового счета
            post = dataBase.save(post);
            post = new Accounts(post);
            post = dataBase.save(post);
            return post;
        }
        else {
            Double money;  //Спичание и зачисление средств
            if (post.getId()!=null) {
                Accounts acc = dataBase.findById(post.getId()).get();
                money = acc.getMoney() + post.getMoney();
                acc.setMoney(money);
                dataBase.save(acc);
                return acc;
            }
            if (post.getNumber()!=null) {
                Accounts acc = dataBase.findByNumber(post.getNumber());
                money = acc.getMoney() + post.getMoney();
                acc.setMoney(money);
                dataBase.save(acc);
                return acc;
            }
        }
        return post;
    }


    @RequestMapping(value = "/account", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Accounts DelMethod(Long id){
        Accounts post = dataBase.findById(id).get();
        dataBase.delete(post);
        return post;
    }


    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Accounts AddMethod(Long id, Long number){
        Accounts post;
        if (id != null) {
            post = dataBase.findById(id).get();
        }
        else {
            if (number != null) {
                post = dataBase.findByNumber(number);
            }
            else {
                post = new Accounts();
            }
        }
        return post;
    }


    @RequestMapping(value = "/account2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Accounts> AddMethod2(String IdCustomer){ //Вывод всех счетов клиента
        return dataBase.findAllByIdCustomerOrderByIdAsc(IdCustomer);
    }

}
