package common;

import common.models.Common;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController //данный класс является REST контроллером.  логика обработки клиентских запросов
public class ControllerRest {


    @RequestMapping(value = "/common", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Common AddMethod(Long id){ //запрос все информации по клиенту

        Common post = new Common();
        RestTemplate restTemplate = new RestTemplate();

        post.setCus(restTemplate.getForObject("http://localhost:8080/user?id="+(id), Common.Customers[].class));
        post.setAcc(restTemplate.getForObject("http://localhost:8081/account2?IdCustomer="+(id), Common.Accounts[].class));
        Double money = 0.0;
        for (Common.Accounts iter:post.acc) {
            money = money + iter.getMoney();
        }
        post.setMoney(money);
        return post;
    }


    @RequestMapping(value = "/common", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Common AddMethod(@RequestBody Common post){ //перевод денег между счетами

        double money;

        RestTemplate restTemplate = new RestTemplate();

        money = post.getMoney();
        post.acc[0].setMoney(-1.0 * money);
        post.acc[0].setall(restTemplate.postForObject("http://localhost:8081/account", post.acc[0], Common.Accounts.class));
        post.acc[1].setMoney(money);
        post.acc[1].setall(restTemplate.postForObject("http://localhost:8081/account", post.acc[1], Common.Accounts.class));

        return post;
    }

}
