package com.ptt.mvc.service;

import com.ptt.mvc.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();

    Project createProject(Project project);

    void deleteProject(int id);

    Project updateProject(Project project);

    Project getProjectById(int id);
}
