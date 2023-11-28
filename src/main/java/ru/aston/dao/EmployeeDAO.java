package ru.aston.dao;

import ru.aston.entity.Employee;
import java.util.List;

public class EmployeeDAO implements EntityDAO<Employee> {
    @Override
    public Employee showById(int id) {
        return null;
    }

    @Override
    public List<Employee> showAll() {
        return null;
    }

    @Override
    public void save(Employee entity) {

    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void delete(Employee entity) {

    }
}
