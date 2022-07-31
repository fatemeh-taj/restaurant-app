package Model;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class DBHandler {

    protected static Connection connection;
    protected static Statement statement;

    public void connect() throws IOException { //connect to DataBase
        System.out.println("server started");
        ServerSocket serverSocket = new ServerSocket();
        // Socket socket= serverSocket.accept();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restapp", "root", "");
            statement = (Statement) connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " from connect -> DataBase");
            e.printStackTrace();
        }
        //serverSocket.close();

    }

    public void addUser(User user) {
        String sqlUserpass = "INSERT INTO `user`(`id`, `username`, `password`) VALUES ('" + user.getId() + "','" + user.getUsername() + "','" + user.getPassword() + "')";//insert data in user table
        try {
            statement.execute(sqlUserpass);
            // statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addClient(Client client) {
        String sqlUserpass = "INSERT INTO `client`(`billId`,`id`,`username`,`password`) VALUES ('" + client.getBillId() + "','" + client.getId() + "','" + client.getUsername() + "','" + client.getPassword() + "')";//insert data in client table
        try {
            statement.execute(sqlUserpass);
            //statement.close();
            // connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addFood(Food food) {
        String sqlUserpass = "INSERT INTO `food`(`id`, `name`, `cost`, `capacity`,`menuId`) VALUES ('" + food.getId() + "','" + food.getName() + "','" + food.getCost() + "','" + food.getCapacity() + "','" + food.getMenuId() + "')";//insert food in food table
        try {
            statement.execute(sqlUserpass);
            // statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void editFood(Food food, int x) throws SQLException {
        String query = "";
        switch (x) {
            case 1://edit food cost by food unique id
                query = "update `food` set `cost` = '" + food.getCost() + "'  where `id` = '" + food.getId() + "'";
                break;

            case 2://edit food capacity by food unique id
                query = "update `food` set `capacity` = '" + food.getCapacity() + "'  where `id` = '" + food.getId() + "'";
                break;

            case 3://edit food cost & capacity by food unique id
                query = "update `food` set `cost`='" + food.getCost() + "',`capacity`='" + food.getCapacity() + "'  where `id` = '" + food.getId() + "'";
                break;
        }
        statement.executeUpdate(query);
        //statement.close();
        //connection.close();

    }

    public void removeFood(int id) throws SQLException {
        String query1 = "delete from  food " + "where id='" + id + "'";//remove food by unique id 
        statement.executeUpdate(query1);
        //statement.close();
        // connection.close();
    }

    public void removeOrder(Order order) throws SQLException {
        String query1 = "delete from  ordertb " + "where id='" + order.getId() + "'";//remove order by unique id 
        statement.executeUpdate(query1);
        //statement.close();
        // connection.close();
    }

    public void deleteAllOrder(Client client) throws SQLException {
        String query = "delete from  ordertb " + "where clientId='" + client.getId() + "'";//remove all client orders
        statement.executeUpdate(query);
    }

    public ArrayList<Food> getListOfFoods() throws SQLException {
        ArrayList<Food> foods = new ArrayList();
        String query = "SELECT*FROM  food ";//all foods
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {//add each food to arraylist
            foods.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("cost"), rs.getInt("capacity"), rs.getInt("menuId")));
        }
        return foods;

    }

    public ArrayList<Order> getListOfOrders() throws SQLException {

        ArrayList<Order> orders = new ArrayList();
        String query = "SELECT*FROM  ordertb ";//all orders
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {//add each order to arraylist
            orders.add(new Order(rs.getInt("id"), rs.getInt("clientId"), rs.getInt("foodPrice"), rs.getInt("foodId"), rs.getString("foodName")));
        }
        return orders;

    }

    public ArrayList<Bill> getListOfBills() throws SQLException {

        ArrayList<Bill> bills = new ArrayList();
        String query = "SELECT*FROM  bill ";//all Bills
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {//add each bill to arraylist
            bills.add(new Bill(rs.getInt("id"), rs.getInt("clientId"), rs.getInt("resId"), rs.getString("foodsId"), rs.getString("foodsName"), rs.getInt("cost")));
        }
        return bills;

    }

    public ArrayList<Restaurant> getListOfRests() throws SQLException {
        ArrayList<Restaurant> resturants = new ArrayList();
        String query = "SELECT*FROM  resturant ";//all resturants
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {//add each resturant to arraylist
            resturants.add(new Restaurant(rs.getInt("id"), rs.getString("name"), rs.getInt("menuId"), rs.getInt("managerId")));
        }
        return resturants;

    }

    public Menu getMenu(int id) throws SQLException {
        Menu model = null;
        String query = "SELECT*FROM  menu WHERE  id ='" + id + "'";//find menu
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            model = new Menu(rs.getInt("id"), rs.getString("foodsId"));
        }
        return model;
    }

    public Food getFood(int id) throws SQLException {
        Food model = null;
        String query = "SELECT*FROM  food WHERE  id ='" + id + "'";//find food
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            model = new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("cost"), rs.getInt("capacity"), rs.getInt("menuId"));
        }
        return model;
    }

    public Order getOrder(int id) throws SQLException {
        Order model = null;
        String query = "SELECT*FROM  ordertb WHERE  id ='" + id + "'";//find order
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            model = new Order(rs.getInt("id"), rs.getInt("clientId"), rs.getInt("foodPrice"), rs.getInt("foodId"), rs.getString("foodName"));
        }
        return model;
    }

    public void addBill(Bill bill) {
        String sqlUserpass = "INSERT INTO `bill`(`id`, `clientId`,`resId`,`foodsId`,`foodsName`,`cost`) VALUES ('" + bill.getId() + "','" + bill.getClientId() + "','" + bill.getResId() + "','" + bill.getFoodsId() + "','" + bill.getFoodsName() + "','" + bill.getCost() + "')";//insert data in bill table
        try {
            statement.execute(sqlUserpass);
            ////statement.close();
            // connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addOrders(Order order) {
        String sqlUserpass = "INSERT INTO `ordertb`(`id`,`clientId`, `foodPrice`,`foodId`,`foodName`) VALUES ('" + order.getId() + "','" + order.getClientId() + "','" + order.getFoodPrice() + "','" + order.getFoodId() + "','" + order.getFoodName() + "')";//insert data in order table
        try {
            statement.execute(sqlUserpass);
            //statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addManager(Manager manager) {
        String sqlUserpass = "INSERT INTO `manager`(`id`, `username`, `password`, `menuId`, `resId`) VALUES ('" + manager.getId() + "','" + manager.getUsername() + "','" + manager.getPassword() + "','" + manager.getMenuId() + "','" + manager.getResId() + "')";//insert data in manager table       
        try {
            statement.execute(sqlUserpass);
            //statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addRestraunt(Restaurant res) {
        String sqlUserpass = "INSERT INTO `resturant`(`name`, `menuId`, `managerId`, `id`) VALUES ('" + res.getName() + "','" + res.getMenuId() + "','" + res.getManagerId() + "','" + res.getId() + "')";//insert data in restraunt table       
        try {
            statement.execute(sqlUserpass);
            //statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public void addMenu(Menu menu) {
        String sqlUserpass = "INSERT INTO `menu`(`id`, `foodsId`) VALUES ('" + menu.getId() + "','" + menu.getFoodsId() + "')";//insert data in menu table       
        try {
            statement.execute(sqlUserpass);
            //statement.close();
            //connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " add");
            e.printStackTrace();
        }

    }

    public User userLogin(String username, String password) throws SQLException {
        User user = null;
        String query = "SELECT*FROM  user ";//all users
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {//check username & password
                user = new User(rs.getInt("id"), username, password);
            }
        }

        return user;
    }

    public Restaurant ManagerLogin(String username, String password) throws SQLException {
        Restaurant restaurant = null;
        int restaurantId = 0;
        String query = "SELECT*FROM  manager ";//all managerss
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {//check username & password
                restaurantId = rs.getInt("resId");
            }
        }

        if (restaurantId != 0) {//correct username & password
            restaurant = getRestaurant(restaurantId);//find restaurant
        }

        return restaurant;
    }

    public Restaurant getRestaurant(int id) throws SQLException {
        Restaurant model = null;
        String query = "SELECT*FROM  resturant WHERE  id ='" + id + "'";//find resturant
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            model = new Restaurant(id, rs.getString("name"), rs.getInt("menuId"), rs.getInt("managerId"));
        }
        return model;
    }
}
