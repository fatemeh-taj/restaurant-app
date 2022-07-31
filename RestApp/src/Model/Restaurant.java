package Model;

public class Restaurant {

    private int id;
    private String name;
    private int menuId;
    private int managerId;

    //constructor
    public Restaurant(int id, String name, int menuId, int managerId) {
        this.id = id;
        this.name = name;
        this.menuId = menuId;
        this.managerId = managerId;
    }

    //getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
}
