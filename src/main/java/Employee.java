public class Employee{

    protected int employeeid;
    protected String name;
    protected int hoursworked;
    protected int salary;
    protected int projectedpay;

    public Employee() {}

    public Employee(int id, String name, int hours, int salary) {
        employeeid = id;
        this.name = name;
        hoursworked = hours;
        this.salary = salary;
    }

    public int getId() {
        return employeeid;
    }

    public String getName() {
        return name;
    }

    public int getHoursworked() {
        return hoursworked;
    }

    public int getSalary() {
        return salary;
    }

    public int getProjectedpay() { return salary * hoursworked; }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        employeeid = id;
    }

    public void setHoursworked(int hours) {
        hoursworked = hours;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setProjectedpay()
    {
        projectedpay = salary * hoursworked;
    }



}
