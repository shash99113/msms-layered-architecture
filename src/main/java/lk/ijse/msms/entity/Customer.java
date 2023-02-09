package lk.ijse.msms.entity;

public class Customer implements SuperEntity{
    private String id;
    private String name;
    private String nic;
    private String address;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String id, String name, String nic, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
