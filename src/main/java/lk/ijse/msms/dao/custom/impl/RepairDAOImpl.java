package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.RepairDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Payment;
import lk.ijse.msms.entity.Repair;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepairDAOImpl implements RepairDAO {

    @Override
    public boolean save(Repair entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO repair VALUES(?, ?, ?, ?, ?)",
                    entity.getRepairId(),
                    entity.getCustomerId(),
                    entity.getDesc(),
                    entity.getReceivedDate(),
                    entity.getStatus()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(Repair entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE repair SET customer_id= ?, description=?, received_date=?, status=? WHERE repair_id = ?",
                    entity.getCustomerId(),
                    entity.getDesc(),
                    entity.getReceivedDate(),
                    entity.getStatus(),
                    entity.getRepairId()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM repair WHERE repair_id=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<Repair> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM repair");
            List<Repair> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new Repair(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4),
                        rst.getString(5)
                ));
            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Repair> findByPk(String pk) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM repair WHERE repair_id=?",pk);
            if (rst.next()){
                return Optional.of(new Repair(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getDate(4),
                        rst.getString(5)
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
            ResultSet result = CrudUtil.executeQuery("SELECT repair_id FROM repair ORDER BY repair_id DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
