package Model;

public class Bill {

    private int id, clientId, resId;
    private String foodsId, foodsName;
    private long cost;

    //constructor
    public Bill(int id, int clientId, int resId, String foodsId, String foodsName, long cost) {
        this.id = id;
        this.clientId = clientId;
        this.resId = resId;
        this.foodsId = foodsId;
        this.foodsName = foodsName;
        this.cost = cost;
    }

    //getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getFoodsId() {
        return foodsId;
    }

    public void setFoodsId(String foodsId) {
        this.foodsId = foodsId;
    }

    public String getFoodsName() {
        return foodsName;
    }

    public void setFoodsName(String foodsName) {
        this.foodsName = foodsName;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
