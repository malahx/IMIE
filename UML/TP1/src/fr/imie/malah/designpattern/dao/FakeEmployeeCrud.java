package fr.imie.malah.designpattern.dao;

import fr.imie.malah.designpattern.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class FakeEmployeeCrud implements Crud<Employee> {

    private static FakeEmployeeCrud instance;

    static {
        instance = new FakeEmployeeCrud();
    }

    public static FakeEmployeeCrud getInstance() {
        return instance;
    }

    private List<Employee> employees;

    private FakeEmployeeCrud() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void create(Employee e) {
        employees.add(e);
    }

    @Override
    public void update(Employee e) {
        employees.stream().filter(employee -> employee.equals(e)).forEach(employee -> {
            employee.setFirstName(e.getFirstName());
            employee.setLastName(e.getLastName());
        });
    }

    @Override
    public void delete(Employee e) {
        employees.remove(e);
    }

    @Override
    public Employee read(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Employee> readAll() {
        return employees;
    }
}
