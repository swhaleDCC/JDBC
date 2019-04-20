package cn.shuangze.assetsms.entity;

import java.io.Serializable;
/**
 * 用户信息类
 */
public class Users implements Serializable{
    private int userno;
    private String username;
    private String password;
    private String phone;
    private String mail;

    public Users(String username, String password, String phone, String mail) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
    }

    public Users(int userno, String username, String password, String phone, String mail) {
        this.userno = userno;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
