package lk.ijse.msms.dao.custom.impl;

import lk.ijse.msms.dao.custom.ItemDAO;
import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.dao.util.CrudUtil;
import lk.ijse.msms.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean save(Item entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("INSERT INTO item VALUES (?, ?, ?, ?, ?, ?)",
                    entity.getItemCode(),
                    entity.getModel(),
                    entity.getType(),
                    entity.getDescription(),
                    entity.getUnitPrice(),
                    entity.getQtyOnStock()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean update(Item entity) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("UPDATE item SET model= ?, type=?, description=?, unit_price=?, qty_on_stock=? WHERE item_code=?",
                    entity.getModel(),
                    entity.getType(),
                    entity.getDescription(),
                    entity.getUnitPrice(),
                    entity.getQtyOnStock(),
                    entity.getItemCode()
            );
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstrainViolationException {
        try {
            return CrudUtil.executeUpdate("DELETE FROM item WHERE item_code=?",pk);
        } catch (SQLException e) {
            throw new ConstrainViolationException(e);
        }
    }

    @Override
    public List<Item> findAll() {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item");
            List<Item> arrayList = new ArrayList<>();
            while (rst.next()){
                arrayList.add(new Item(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getDouble(5),
                        rst.getInt(6)
                ));

            }
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Item> findByPk(String pk) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item WHERE item_code=?",pk);
            if (rst.next()){
                return Optional.of(new Item(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getDouble(5),
                        rst.getInt(6)
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
            ResultSet result = CrudUtil.executeQuery("SELECT item_code FROM item ORDER BY item_code DESC LIMIT 1");
            if (result.next()) {
                return Optional.of(result.getString(1));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
