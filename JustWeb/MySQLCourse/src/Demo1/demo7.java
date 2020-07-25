package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class demo7 {
    /*定义一个方法，查询emp表中数据并将其封装成对象
    ，然后装载进集合，返回集合。通过浏览器访问的时候能够拿到集合的json数据。
     */
    @Test
    public List<Emp> findAll() throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();

        try(connection;statement;statement1){
            String sql = "select * from emp";

            ResultSet rs = statement.executeQuery(sql);

            List<Emp> list = new ArrayList<Emp>();

            while (rs.next()){
                Emp emp = new Emp();

                int id = rs.getInt("id");
                emp.setId(id);

                String name = rs.getString("name");
                emp.setName(name);

                Date date = rs.getDate("joinDate");
                emp.setJoinDate(date);

                int salary = rs.getInt("salary");
                emp.setSalary(salary);

                ResultSet resultSet = statement1.executeQuery("select * from dept");
                Dept dept = new Dept();
                resultSet.next();
                dept.setId(resultSet.getInt("id"));
                dept.setName(resultSet.getString("name"));

                emp.setDept(dept);
                list.add(emp);
            }
        }




        return null;
    }

}
class Emp{
    private int id;
    private String name;
    private String gender;
    private int salary;
    private Date joinDate;
    private Dept dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", dept=" + dept +
                '}';
    }
}

class Dept{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
