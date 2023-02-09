package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.PaymentDetailsDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Payment;
import lk.ijse.msms.entity.PaymentDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentDetailsDAOImpl implements PaymentDetailsDAO {

    @Override
    public boolean save(PaymentDetail entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO payment_details VALUES(?, ?, ?, ?)",
                    entity.getItemCode(),
                    entity.getPaymentId(),
                    entity.getQty(),
                    entity.getUnitPrice()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(PaymentDetail entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE payment_details SET item_code= ?, qty=?, unit_price=? WHERE payment_id = ?",
                    entity.getItemCode(),
                    entity.getQty(),
                    entity.getUnitPrice(),
                    entity.getPaymentId()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM payment_details WHERE payment_id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<PaymentDetail> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM payment_details");
            List<PaymentDetail> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new PaymentDetail(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getDouble(4)
                ));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<PaymentDetail> findByPk(String pk) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM payment_details WHERE payment_id=?",pk);
            if (rst.next()){
                return Optional.of(new PaymentDetail(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getInt(3),
                        rst.getDouble(4)
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
            ResultSet result = CrudUtil.executeQuery("SELECT payment_id FROM payment_details ORDER BY payment_id DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
