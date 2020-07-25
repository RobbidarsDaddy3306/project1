package Bank.pojo;

public class Person {

    private String no; //序列号
    private String userName;  //找好
    private String password;  //密码
    private String sex;       //性别
    private String address;   //地址
    private Double balance;   //余额

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Person(String no, String userName, String password, String sex, String address, Double balance) {
        this.no = no;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.address = address;
        this.balance = balance;
    }

    public Person(){

    }
}
