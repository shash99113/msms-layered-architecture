package lk.ijse.msms.dao;

import lk.ijse.msms.dao.exception.ConstrainViolationException;
import lk.ijse.msms.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDAO <T extends SuperEntity,ID extends Serializable> extends SuperDAO{
    public boolean save(T entity) throws ConstrainViolationException;
    public boolean update(T entity) throws ConstrainViolationException;
    public boolean deleteByPk(ID pk) throws ConstrainViolationException;
    public List<T> findAll();
    public Optional<T> findByPk(ID pk);
    public Optional<ID> findLastPk();
}
