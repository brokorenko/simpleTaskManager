package com.andy.dao;

import com.andy.model.Project;
import com.andy.model.Task;

import java.util.List;

/**
 * Created by Andrew on 10.05.2017.
 */
public interface TaskDAO {
    public List<Task> getAllProjectTasks(int projectId);
    public void createNewTask(Task task);
}
