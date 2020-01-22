package com.m2micro.smartFactory.model;

public class User {

  private int id;
  private String userName;
  private int  age ;
  private String position;
  private String password;


  public User() {
  }

  public User(int id, String userName, int age, String position, String password) {
    this.id = id;
    this.userName = userName;
    this.age = age;
    this.position = position;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
