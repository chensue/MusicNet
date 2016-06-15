package com.musicnet.bean;

public class UserInfo
{
    private int uid;
    private String uname;
    private String email;
    private String pwd;
    private int phone;
    public int getUid()
    {
        return uid;
    }
    public void setUid(int uid)
    {
        this.uid = uid;
    }
    public String getUname()
    {
        return uname;
    }
    public void setUname(String uname)
    {
        this.uname = uname;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPwd()
    {
        return pwd;
    }
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    public int getPhone()
    {
        return phone;
    }
    public void setPhone(int phone)
    {
        this.phone = phone;
    }
    @Override
    public String toString()
    {
        return "UserInfo [uid=" + uid + ", uname=" + uname + ", email=" + email + ", pwd=" + pwd + ", phone=" + phone + "]";
    }
    
}
