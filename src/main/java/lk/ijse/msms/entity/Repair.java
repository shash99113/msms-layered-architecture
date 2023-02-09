package lk.ijse.msms.entity;

import java.sql.Date;

public class Repair implements SuperEntity{
    private String repairId;
    private String customerId;
    private String desc;
    private Date receivedDate;
    private String status;

    public Repair() {
    }

    public Repair(String repairId, String customerId, String desc, Date receivedDate, String status) {
        this.repairId = repairId;
        this.customerId = customerId;
        this.desc = desc;
        this.receivedDate = receivedDate;
        this.status = status;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
