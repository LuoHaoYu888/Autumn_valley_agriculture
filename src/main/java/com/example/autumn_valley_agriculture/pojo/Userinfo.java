package com.example.autumn_valley_agriculture.pojo;

import lombok.Data;

@Data
public class Userinfo {

  private int id;
  private String name;
  private String account;
  private String password;
  private int isAdmin;
  private String role;
  private int useStatus;
  private String phone;
  private String address;
  private String content;

}
