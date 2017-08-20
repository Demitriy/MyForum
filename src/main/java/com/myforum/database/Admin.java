package com.myforum.database;

/**
 * Created by Dima on 20.08.2017.
 */
public class Admin {

    private int id;
    private User user;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
