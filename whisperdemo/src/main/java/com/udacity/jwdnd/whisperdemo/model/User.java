package com.udacity.jwdnd.whisperdemo.model;

public class User {
    private Integer userid; //INT PRIMARY KEY auto_increment,
    private String username; // VARCHAR(20),
    private String salt; // VARCHAR,
    private String password; // VARCHAR,
    private String firstname; // VARCHAR(20),
    private String lastname; // VARCHAR(20)

    public User(Integer userid, String username, String salt, String password, String firstname, String lastname) {
        this.userid = userid;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }



    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        System.out.println("get Username USer class "+username);
        return username;
    }

    public void setUsername(String username) {
        System.out.println("set Username USer class "+username);
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
