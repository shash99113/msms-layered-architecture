package lk.ijse.msms.entity;

public class RepairPaymentDetail implements SuperEntity{
    private String paymentId;
    private String repairId;
    private double repairPrice;

    public RepairPaymentDetail() {
    }

    public RepairPaymentDetail(String paymentId, String repairId, double repairPrice) {
        this.paymentId = paymentId;
        this.repairId = repairId;
        this.repairPrice = repairPrice;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public double getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(double repairPrice) {
        this.repairPrice = repairPrice;
    }
}
