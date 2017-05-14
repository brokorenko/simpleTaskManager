package com.andy.dao;

import com.andy.model.Developer;
import com.andy.model.Task;

/**
 * Created by Andrew on 13.05.2017.
 */
public interface DeveloperDAO {
    public Developer getDeveloperByName(Developer developer);
    public void setTaskForDeveloper(Task task);
}
