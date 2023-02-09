package lk.ijse.msms.entity;

public class PaymentDetail implements SuperEntity{
    private String itemCode;
    private String paymentId;
    private int qty;
    private Double unitPrice;

    public PaymentDetail() {
    }

    public PaymentDetail(String itemCode, String paymentId, int qty, Double unitPrice) {
        this.itemCode = itemCode;
        this.paymentId = paymentId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
