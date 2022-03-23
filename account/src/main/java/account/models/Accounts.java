package account.models;

        import javax.persistence.*;


@Entity //класс-сущность
@Table(name = "Accounts")
public class Accounts {
    @Id // указывает на поле - уникальный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    //@Id // указывает на поле - уникальный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column
    private String idCustomer;

    @Column
    private Double money;


    public Accounts() {
    }



    public Accounts(Accounts acc) {
        this.idCustomer = acc.idCustomer;
        this.id = acc.id;
        this.number = (long)(Long.toString(acc.id).hashCode());
        this.money=(double)0;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
