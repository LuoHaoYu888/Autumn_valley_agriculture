package com.example.autumn_valley_agriculture.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

  private String studentNo;
  private String loginPwd;
  private String studentName;
  private String sex;
  private int gradeId;
  private String phone;
  private String address;
  private Date bornDate;
  private String email;

}