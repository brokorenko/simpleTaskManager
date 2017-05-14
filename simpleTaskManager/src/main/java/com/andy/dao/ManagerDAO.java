package com.andy.dao;

import com.andy.model.Manager;

import java.util.List;

/**
 * Created by Andrew on 16.03.2017.
 */
public interface ManagerDAO {
    public void save(Manager manager);

    public List<Manager> list();

    public Manager getManagerById(int id);

    public Manager getManagerByLoginForm(String managerLogin, String managerPassword);
    public int getIdByManagerLogin(String login);
}
