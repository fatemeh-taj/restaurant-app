package Model;

public class Food {

    private int id, cost, capacity, menuId;
    private String name;

    //constructor
    public Food(int id, String name, int cost, int capacity, int menuId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.menuId = menuId;
    }

    public Food() {

    }

    //getter & setter
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
