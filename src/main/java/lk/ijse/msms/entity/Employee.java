package lk.ijse.msms.entity;

public class Employee implements SuperEntity{
    private String employeeID;
    private String rank;
    private String name;
    private String nicNumber;
    private String address;
    private String phone;

    public Employee() {
    }

    public Employee(String employeeID, String rank, String name, String nicNumber, String address, String phone) {
        this.employeeID = employeeID;
        this.rank = rank;
        this.name = name;
        this.nicNumber = nicNumber;
        this.address = address;
        this.phone = phone;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
