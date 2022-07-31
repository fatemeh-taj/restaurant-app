package Model;

public class Client extends User {

    private int billId;

    //constructor
    public Client(int billId, int id, String username, String password) {
        super(id, username, password);
        this.billId = billId;
    }

    //getter & setter
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

}
