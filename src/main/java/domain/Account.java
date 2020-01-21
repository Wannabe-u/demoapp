package domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String user;
    private String passwd;

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}