package com.sanjeevaniehr.user.registration.services;

// package com.sanjeevaniehr.user.registration.services;
//
// import java.sql.Statement;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
//
// import com.sanjeevaniehr.user.registration.services.User ;
//
//
// public class DatabaseTest {
//
//
// Connection connection = null;
//
// Statement statement = null;
//
// ResultSet rs = null;
//
//
//
// private Connection getConnection() throws InstantiationException,
// IllegalAccessException {
//
// String driverName = "com.mysql.jdbc.Driver";
//
// String conectionURI = "jdbc:mysql://localhost/sanjeevani";
//
// String userName = "root";
//
// String password = "";
//
//
//
//
//
// try {
//
// Class.forName(driverName).newInstance();
//
//
// try {
//
// connection = DriverManager.getConnection(conectionURI, userName, password);
//
// System.out.println(connection) ;
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// try {
//
// connection.setAutoCommit(true);
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
//
//
// } catch (ClassNotFoundException e) {
//
// e.printStackTrace();
//
// }
//
//
//
// return connection;
//
// }
//
//
//
// //CREATE operation
//
// public void addUser(User users) throws InstantiationException,
// IllegalAccessException {
//
//
//
//
//
// try {
//
// connection = getConnection();
// if(!connection.isClosed())
// {
// System.out.println("successfully connected to" + "MySQL sever using
// TCP/IP.."); }
//
// statement = connection.createStatement();
//
//
// System.out.println("inside the adduser before insert");
//
// String sqlStatement = "INSERT INTO users" +
// "(user_type,user_email,user_pass,user_firstname,user_lastname)" + "values(" +
// users.getuser_type() + "'" + ",'" + users.get_email() +"'" + ",'" +
// users.getuser_pass() +"'" + ",'" + users.get_firstname() +"'" + ",'" +
// users.get_lastname() + "')";
//
// System.out.println(sqlStatement) ;
// statement.executeUpdate(sqlStatement);
//
//
//
// } catch (SQLException e) {
//
//
//
// } finally {
//
// if (statement != null) {
//
// try {
//
// statement.close();
//
// } catch (SQLException e) {
//
// e.printStackTrace();
//
// }
//
// }
//
//
//
// if (connection != null) {
//
// try {
//
// connection.close();
//
// } catch (SQLException e) {
//
//
//
// e.printStackTrace();
//
// }
//
// }
//
// }
//
//
//
//
//
// }
//
// public static void main( String [] args) throws InstantiationException,
// IllegalAccessException
// {
//
// DatabaseTest t = new DatabaseTest() ;
//
// User users = new User() ;
//
// // Setters
//
// users.setuser_type("P");
// users.set_firstname("Anitha");
// users.set_lastname("Ilapakurti");
// users.setuser_pass("Sriya");
// users.set_email("anitha_sjsu@yahoo.com");
// t.addUser(users);
// System.out.println("DONE");
//
//
//
// }
// }