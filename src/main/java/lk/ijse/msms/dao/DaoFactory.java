package lk.ijse.msms.dao;

import lk.ijse.msms.dao.custom.EmployeeDAO;
import lk.ijse.msms.dao.custom.impl.*;

public class DaoFactory {
    public static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }
    public <T>T getDao(DaoTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case PAYMENT_DETAILS:
                return (T) new PaymentDetailsDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case REPAIR:
                return (T) new RepairDAOImpl();
            case REPAIR_PAYMENT_DETAILS:
                return (T) new RepairPaymentDetailDAOImpl();
            default:
                return null;
        }
    }
}
