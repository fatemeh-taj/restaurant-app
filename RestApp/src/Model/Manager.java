package Model;

public class Manager extends User {

    private int resId, menuId;

    //constructor
    public Manager(int resId, int menuId, int id, String username, String password) {
        super(id, username, password);
        this.resId = resId;
        this.menuId = menuId;
    }

    //getter & setter
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

}
