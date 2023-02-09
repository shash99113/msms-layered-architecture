package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.PaymentDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Item;
import lk.ijse.msms.entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO payment VALUES(?, ?, ?, ?)",
                    entity.getPaymentId(),
                    entity.getCustomerId(),
                    entity.getPaymentType(),
                    entity.getDate()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(Payment entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE payment SET customer_id= ?, payment_type=?, date=? WHERE payment_id = ?",
                    entity.getCustomerId(),
                    entity.getPaymentType(),
                    entity.getDate(),
                    entity.getPaymentId()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM payment WHERE payment_id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<Payment> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM payment");
            List<Payment> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new Payment(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4)
                ));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Payment> findByPk(String pk) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM payment  WHERE payment_id=?",pk);
            if (rst.next()){
                return Optional.of(new Payment(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4)
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
            ResultSet result = CrudUtil.executeQuery("SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
