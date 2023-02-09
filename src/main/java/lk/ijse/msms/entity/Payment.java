package lk.ijse.msms.entity;

import java.sql.Date;

public class Payment implements SuperEntity{
    private String paymentId;
    private String customerId;
    private String paymentType;
    private Date date;

    public Payment() {
    }

    public Payment(String paymentId, String customerId, String paymentType, Date date) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.date = date;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
