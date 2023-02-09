package lk.ijse.msms.entity;

public class Item implements SuperEntity{
    private String itemCode;
    private String model;
    private String type;
    private String description;
    private Double unitPrice;
    private int qtyOnStock;

    public Item() {
    }

    public Item(String itemCode, String model, String type, String description, Double unitPrice, int qtyOnStock) {
        this.itemCode = itemCode;
        this.model = model;
        this.type = type;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnStock = qtyOnStock;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnStock() {
        return qtyOnStock;
    }

    public void setQtyOnStock(int qtyOnStock) {
        this.qtyOnStock = qtyOnStock;
    }
}
