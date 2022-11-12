package com.example.library;

public class LogInObject {

   private Integer id;
   private String Name;
   private String Email;
   private String Password;

    public LogInObject(Integer id, String name, String email, String password) {
        this.id = id;
        Name = name;
        Email = email;
        Password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
