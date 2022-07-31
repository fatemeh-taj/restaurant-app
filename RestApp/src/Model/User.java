package Model;

public class User {

    protected int id;
    protected String username, password;

    //constructor
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //getter & setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
