package task3pageobject;

import java.util.Objects;

public class Employee {
    private String name;
    private String possition;
    private String office;

    public String getName() {return name; }

    public void setName(String name) {this.name=name;}

    public String getPossition() {return possition;}

    public void setPossition(String possition) {this.possition=possition;}

    public String getOffice() {return office;}

    public void setOffice(String office) {this.office=office;}

    public Employee(String name, String possition, String office) {
        this.name=name;
        this.possition=possition;
        this.office=office;
    }
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", possition='" + possition + '\'' +
                ", office='" + office + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee=(Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(possition, employee.possition) &&
                Objects.equals(office, employee.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, possition, office);
    }
}
