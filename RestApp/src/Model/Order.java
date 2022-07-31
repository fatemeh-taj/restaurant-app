package Model;

public class Order {

    private int id, clientId, foodPrice, foodId;
    private String foodName;

    //constructor
    public Order(int id, int clientId, int foodPrice, int foodId, String foodName) {
        this.id = id;
        this.clientId = clientId;
        this.foodPrice = foodPrice;
        this.foodId = foodId;
        this.foodName = foodName;
    }

    public Order() {
    }

    //getter & setter
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

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

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
