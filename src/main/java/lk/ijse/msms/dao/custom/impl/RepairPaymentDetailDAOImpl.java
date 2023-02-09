package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.RepairPaymentDetailDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Repair;
import lk.ijse.msms.entity.RepairPaymentDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepairPaymentDetailDAOImpl implements RepairPaymentDetailDAO {

    @Override
    public boolean save(RepairPaymentDetail entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO repair_payment_detail VALUES(?, ?, ?)",
                    entity.getPaymentId(),
                    entity.getRepairId(),
                    entity.getRepairPrice()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(RepairPaymentDetail entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE repair_payment_detail SET repair_id= ?, repair_price=? WHERE payment_id = ?",
                    entity.getRepairId(),
                    entity.getRepairPrice(),
                    entity.getRepairPrice()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM repair_payment_detail WHERE payment_id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<RepairPaymentDetail> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM repair_payment_detail");
            List<RepairPaymentDetail> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new RepairPaymentDetail(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getDouble(3)
                ));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RepairPaymentDetail> findByPk(String pk) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM repair_payment_detail WHERE payment_id=?",pk);
            if (rst.next()){
                return Optional.of(new RepairPaymentDetail(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getDouble(3)
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
            ResultSet result = CrudUtil.executeQuery("SELECT payment_id FROM repair_payment_detail ORDER BY payment_id DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
