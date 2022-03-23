package account.DB;

import account.models.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface DataBase extends CrudRepository<Accounts, Long> {

    Accounts findByNumber(Long number); //Поиск по номеру
    Iterable<Accounts> findAllByIdCustomerOrderByIdAsc(String IdCustomer); //Поиск всех записей (определенного клиента) с сортировкой по Id


}
