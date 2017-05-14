package com.andy.dao;

import com.andy.model.Manager;
import com.andy.model.Project;

import java.util.List;
import java.util.Set;

/**
 * Created by Andrew on 28.03.2017.
 */
public interface ProjectDAO {
    public List<Project> getAllManagerProjects(int managerId);
    public void createNewProject(Project project);
}
