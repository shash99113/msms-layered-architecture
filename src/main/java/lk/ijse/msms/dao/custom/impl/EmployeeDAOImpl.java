package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.EmployeeDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(Employee entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)",
                    entity.getEmployeeID(),
                    entity.getRank(),
                    entity.getName(),
                    entity.getNicNumber(),
                    entity.getAddress(),
                    entity.getPhone()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(Employee entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE employee SET `rank`= ?, name=?, nic=?, address=?, phone=? WHERE employee_id=?",
                    entity.getRank(),
                    entity.getName(),
                    entity.getNicNumber(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmployeeID()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM employee WHERE employee_id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM employee");
            List<Employee> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new Employee(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6)
                ));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employee> findByPk(String pk) {
        try {
            ResultSet result = CrudUtil.executeQuery("SELECT  * FROM employee WHERE employee_id = ?", pk);
            if (result.next()) {
                return Optional.of(new Employee(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)
                ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<String> findLastPk() {
        try {
            ResultSet result = CrudUtil.executeQuery("SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}