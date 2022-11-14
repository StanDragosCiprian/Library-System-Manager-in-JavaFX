package com.example.library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MySqlConnect {
    /*
    String MySQLURL = "jdbc:mysql://localhost:3310/libraryporjectjava?useSSL=false";
            String databseUserName = "root";
            String databasePassword = "";
     */
    private String MySQLURL;
    private String databseUserName;
    private String databasePassword;
    private Connection con;

    List<LogInObject> objectList = new ArrayList<>();

    public MySqlConnect() {
        this.MySQLURL = "jdbc:mysql://localhost:3310/libraryporjectjava?useSSL=false";
        this.databseUserName = "root";
        this.databasePassword = "";
        this.con = null;
    }

    public Connection getConnection() {


        try {
            this.con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (this.con != null) {
                return this.con;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return this.con;
    }

    public void mySqlInsertQuery(String query) throws SQLException {
        try {
            Statement stinsert = con.createStatement();
            stinsert.executeUpdate(query);
            con.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public List<LogInObject> Select() {

        try {
            String query = "SELECT * FROM log_in";

            // create the java statement

            Statement st = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String Name = rs.getString("Name");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                LogInObject logInObject = new LogInObject(id, Name, Email, Password);
                objectList.add(logInObject);


            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return objectList;
    }

    public boolean isNotDublicate(String Email) {
        this.objectList = Select();
        for (LogInObject z : objectList.stream().filter(z -> z.getEmail().equals(Email)).toList()) {
            return false;
        }
        return true;
    }
    public boolean uniqAccount(String Email,String Password){
        this.objectList = Select();
        boolean ceva=false;

        for (int i = 0; i <= this.objectList.size(); i++) {
            if(this.objectList.get(i).getEmail().equals(Email)&&this.objectList.get(i).getPassword().equals(Password)){
                ceva= true;
                break;
            }else {
                ceva= false;
            }
        }
        return ceva;
    }

}

