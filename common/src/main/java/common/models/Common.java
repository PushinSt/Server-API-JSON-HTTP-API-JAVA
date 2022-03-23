package common.models;

public class Common { //общий класс, объединяет клиента и его счета

    static public class Customers {
        private Long id;
        private String name;
        private String phone;

        public Customers() {
        }

        public Customers(Long id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    static public class Accounts {
        private Long id;
        private Long number;
        private String idCustomer;;
        private Double money;

        public Accounts() {
        }

        public void setall(Accounts acc) {
            this.id = acc.id;
            this.number = acc.number;
            this.idCustomer = acc.idCustomer;
            this.money = acc.money;
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

    public Customers[] cus;
    public Accounts[] acc;
    public Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Common() {
        money = 0.0;
    }

    public Customers[] getCus() {
        return cus;
    }

    public void setCus(Customers[] cus) {
        this.cus = cus;
    }

    public Accounts[] getAcc() {
        return acc;
    }

    public void setAcc(Accounts[] acc) {
        this.acc = acc;
    }
}




/*
public class Common {

    private String empNo;
    private String empName;
    private String position;

    public Common() {

    }

    public Common(String empNo, String empName, String position) {
        this.empNo = empNo;
        this.empName = empName;
        this.position = position;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}

*/

/*
public class Common {

    private Wing leftWing = new Wing("Red", "X3"), rightWing = new Wing("Blue", "X3");

    public Common() {
    }



    public class Wing {
        private String color, model;

        private Wing(String color, String model) {
            this.color = color;
            this.model = model;
        }

        // getters/setters

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

    // getters/setters


    public Wing getLeftWing() {
        return leftWing;
    }

    public void setLeftWing(Wing leftWing) {
        this.leftWing = leftWing;
    }

    public Wing getRightWing() {
        return rightWing;
    }

    public void setRightWing(Wing rightWing) {
        this.rightWing = rightWing;
    }
}
*/

