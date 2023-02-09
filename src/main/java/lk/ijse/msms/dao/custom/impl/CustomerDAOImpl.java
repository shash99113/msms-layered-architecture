package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.CustomerDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)",
                    entity.getId(),
                    entity.getName(),
                    entity.getNic(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(Customer entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE customer SET name=?, nic=?, address=?, phone=?, email=? WHERE id=?",
                    entity.getName(),
                    entity.getNic(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail(),
                    entity.getId()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM customer WHERE id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM customer");
            List<Customer> arrayList = new ArrayList<>();
            while (rst.next()) {
                arrayList.add(new Customer(
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
    public Optional<Customer> findByPk(String pk) {
        try {
            ResultSet result = CrudUtil.executeQuery("SELECT  * FROM Customer WHERE id = ?", pk);
            if (result.next()) {
                return Optional.of(new Customer(
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
            ResultSet rst = CrudUtil.executeQuery("SELECT id FROM customer ORDER BY id DESC LIMIT 1");
            if (rst.next()) {
                return Optional.of(rst.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
