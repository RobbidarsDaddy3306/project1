package Bank.pojo;

import java.util.Date;

public class History {
    private String no;
    private String userName;
    private Double income;
    private Double expense;
    private Double balance;
    private Date   date;
    private String comment;

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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public History(String no, String userName, Double income, Double expense, Double balance, Date date, String comment) {
        this.no = no;
        this.userName = userName;
        this.income = income;
        this.expense = expense;
        this.balance = balance;
        this.date = date;
        this.comment = comment;
    }

    public History() {

    }
}
