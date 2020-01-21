package com.lemo.pojo;

import lombok.Data;

/**
 * @program: ServletDemo
 * @description
 * @author: NiuBenQi
 * @create: 2020-01-12 14:01
 **/
@Data
public class User {

    private int userId;
    private String userName;
    private String userPwd;

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User() {

    }

    public int getUsreId() {
        return userId;
    }

    public void setUsreId(int usreId) {
        this.userId = usreId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public User(int usreId, String userName, String userPwd) {
        this.userId = usreId;
        this.userName = userName;
        this.userPwd = userPwd;
    }

//    @Override
//    public String toString() {
//        User u = new User();
//        return u.userName;
////        return getUsreId()+getUserName()+getUserPwd();
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

}
