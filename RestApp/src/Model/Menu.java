package Model;

public class Menu {

    private int id;
    private String foodsId;

    //constructor
    public Menu(int id, String foodsId) {
        this.id = id;
        this.foodsId = foodsId;
    }

    public Menu(int id) {
        this.id = id;
    }

    //getter & setter
    public String getFoodsId() {
        return foodsId;
    }

    public void setFoodsId(String foodsId) {
        this.foodsId = foodsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
