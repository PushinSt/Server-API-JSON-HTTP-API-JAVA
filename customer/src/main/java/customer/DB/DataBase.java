package customer.DB;

import customer.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface DataBase extends CrudRepository<Customers, Long> {

    Iterable<Customers> findAllByOrderByIdAsc(); //Вывод всех записей с сортировкой по Id


}
